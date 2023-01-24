package com.soses.audit.service.customer.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerAddressRequest;
import com.soses.audit.api.customer.CustomerAddressResponse;
import com.soses.audit.bo.CustomerAddressBO;
import com.soses.audit.bo.CustomerBO;
import com.soses.audit.cache.municipal.MunicipalCacheService;
import com.soses.audit.cache.province.ProvinceCacheService;
import com.soses.audit.cache.region.RegionCacheService;
import com.soses.audit.common.CustomerAddressHelper;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerAddressTO;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.CustomerAddress;
import com.soses.audit.entity.CustomerAddressHistory;
import com.soses.audit.repository.CustomerAddressHistoryRepository;
import com.soses.audit.repository.CustomerAddressRepository;
import com.soses.audit.service.customer.BaseCustomerService;
import com.soses.audit.util.CustomerAddressTransformerUtil;

import jakarta.transaction.Transactional;

@Service("CustomerAddressServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerAddressServiceImpl implements BaseCustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerAddressServiceImpl.class);
	
	private CustomerBO customerBO;
	
	private CustomerAddressBO customerAddressBO;
	
	private CustomerAddressRepository customerAddressRepo;
	
	private CustomerAddressHistoryRepository customerAddressHistoryRepo;
	
	private RegionCacheService regionCache;
	
	private ProvinceCacheService provinceCache;
	
	private MunicipalCacheService  municipalCache;
	
	public CustomerAddressServiceImpl(CustomerBO customerBO, CustomerAddressRepository customerAddressRepo
			, CustomerAddressBO customerAddressBO, RegionCacheService regionCache
			, ProvinceCacheService provinceCache, MunicipalCacheService  municipalCache
			, CustomerAddressHistoryRepository customerAddressHistoryRepo) {
		super();
		this.customerBO = customerBO;
		this.customerAddressBO = customerAddressBO;
		this.customerAddressRepo = customerAddressRepo;
		this.customerAddressHistoryRepo = customerAddressHistoryRepo;
		this.regionCache = regionCache;
		this.provinceCache = provinceCache;
		this.municipalCache = municipalCache;
	}
	
	@Override
	public BaseCustomerResponse getCustomerDetails(String customerCode) {
		CustomerAddressResponse response = new CustomerAddressResponse();
		List<CustomerAddressTO> customerAddressTOList = null;
		response.setCustomerCode(customerCode);
		int customerId = 0;
		try {
			// Get Customer Details
			CustomerTO customerDTO = customerBO.retrieveCustomer(customerCode);
			if (customerDTO == null) {
				throw new Exception("getCustomerDetails(String customerCode): Customer is null.");
			}
			response.setCustomerTO(customerDTO);
			customerId = customerDTO.getCustomerId();
			response.setCustomerId(customerId);
			
			List<CustomerAddress> customerAddressList = customerAddressBO.getCustomerAddressList(customerId);
			if (GeneralUtil.isListEmpty(customerAddressList)) {
				throw new Exception("getCustomerDetails(String customerCode): Customer Address is null.");
			}
			customerAddressTOList = new ArrayList<>();
			for (CustomerAddress customerAddress : customerAddressList) {
				CustomerAddressTO customerAddressTO = CustomerAddressTransformerUtil.transformCustomerAddressEntity(customerAddress);
				deriveAddressCache(customerAddress, customerAddressTO);
				customerAddressTOList.add(customerAddressTO);
			}
			
			response.setCustomerAddressList(customerAddressTOList);

		} catch (Exception ex) {
			log.error(ex.getMessage());
			//ex.printStackTrace();
		}
		return response;
	}
	
	public boolean updateCustomerAddress(CustomerAddressRequest request) {
		
		boolean isSuccess = false;
		if (request == null || GeneralUtil.isListEmpty(request.getCustomerAddress())) {
			return isSuccess;
		}
		List<CustomerAddress> reqCustomerAddressList = request.getCustomerAddress();
		List<CustomerAddress> customerAddressList = new ArrayList<>();
		List<CustomerAddressHistory> customerAddressHistoryList = new ArrayList<>();
		int customerId = request.getCustomerId();
		try {
			List<CustomerAddress> dbCustomerAddressList = customerAddressBO.getCustomerAddressList(customerId);
			if (dbCustomerAddressList == null) {
				//error
			}
			for (int i = 0; i < dbCustomerAddressList.size(); i++) {
				CustomerAddress dbCustomerAddress = dbCustomerAddressList.get(i);
				CustomerAddress reqCustomerAddress = reqCustomerAddressList.get(i);
				if (CustomerAddressHelper.isChanged(dbCustomerAddress, reqCustomerAddress)) {
					// create employee address history
					CustomerAddressHistory customerAddressHistory = CustomerAddressHelper.convertToCustomerAddressHistory(dbCustomerAddress);
					
					String username = SecurityContextHolder.getContext().getAuthentication().getName();
					customerAddressHistory.setUserCode(username);
					reqCustomerAddress.setUserCode(username);
					reqCustomerAddress.setEntryTimestamp(LocalDateTime.now());
					
					customerAddressHistoryList.add(customerAddressHistory);
					customerAddressList.add(reqCustomerAddress);
				}
			}
			
			if (!GeneralUtil.isListEmpty(customerAddressHistoryList) 
					&& !GeneralUtil.isListEmpty(customerAddressList)) {
				customerAddressHistoryList = customerAddressHistoryRepo.saveAll(customerAddressHistoryList);
				customerAddressList = customerAddressRepo.saveAll(customerAddressList);
			}
			
			
			isSuccess=true;
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		
		return isSuccess;
	}
	
	private void deriveAddressCache(CustomerAddress customerAddress, CustomerAddressTO customerAddressTO) {
		if (customerAddress != null && customerAddressTO != null) {
			int regionId = customerAddress.getRegion();
			if (regionId > 0) {
				customerAddressTO.setRegionList(regionCache.findAll());
				int provinceId = customerAddress.getProvince();
				if(provinceId > 0) {
					customerAddressTO.setProvinceList(provinceCache.getProvinceListByRegion(Integer.toString(regionId)));
					int municipalId = customerAddress.getMunicipal();
					if (municipalId > 0) {
						customerAddressTO.setMunicipalList(municipalCache.getMunicipalListByProvince(Integer.toString(provinceId)));
					}
				}
			}
		}
	}

}
