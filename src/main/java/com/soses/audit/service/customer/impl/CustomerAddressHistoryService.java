package com.soses.audit.service.customer.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.audit.api.customer.BaseCustomerResponse;
import com.soses.audit.api.customer.CustomerAddressHistoryResponse;
import com.soses.audit.cache.municipal.MunicipalAccessor;
import com.soses.audit.cache.province.ProvinceAccessor;
import com.soses.audit.cache.region.RegionAccessor;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerAddressHistoryTO;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.entity.Customer;
import com.soses.audit.entity.CustomerAddressHistory;
import com.soses.audit.entity.Municipal;
import com.soses.audit.entity.Province;
import com.soses.audit.entity.Region;
import com.soses.audit.entity.User;
import com.soses.audit.repository.CustomerAddressHistoryRepository;
import com.soses.audit.repository.CustomerRepository;
import com.soses.audit.service.user.UserService;
import com.soses.audit.util.CustomerAddressHistoryTransformerUtil;
import com.soses.audit.util.CustomerTransformerUtil;

import jakarta.transaction.Transactional;

@Service("CustomerAddressHistoryServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerAddressHistoryService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerAddressHistoryService.class);

	private CustomerAddressHistoryRepository customerAddressHistoryRepo;
	
	private CustomerRepository customerRepo;
	
	private UserService userService;
	
	private RegionAccessor regionAccessor;
	
	private ProvinceAccessor provinceAccessor;
	
	private MunicipalAccessor municipalAccessor;
	
	public CustomerAddressHistoryService(CustomerAddressHistoryRepository customerAddressHistoryRepo
			, CustomerRepository customerRepo, UserService userService
			, RegionAccessor regionAccessor, ProvinceAccessor provinceAccessor
			, MunicipalAccessor municipalAccessor) {
		super();
		this.customerAddressHistoryRepo = customerAddressHistoryRepo;
		this.customerRepo = customerRepo;
		this.userService = userService;
		this.regionAccessor = regionAccessor;
		this.provinceAccessor = provinceAccessor;
		this.municipalAccessor = municipalAccessor;
	}

	public BaseCustomerResponse getCustomerAddressHistoryDetails(String customerCode, String addressType) {
		log.info("ENTER: getCustomerAddressHistoryDetails(String customerCode, String addressType)");
		CustomerAddressHistoryResponse res = new CustomerAddressHistoryResponse();

		try {
			Customer customer = customerRepo.findByCustomerCode(customerCode);
			if (customer == null) {
				throw new Exception("Customer is null. Invalid Customer Code");
			}
			CustomerTO customerTO = CustomerTransformerUtil.transformCustomerEntity(customer);
			res.setCustomerTO(customerTO);

			String customerId = Integer.toString(customer.getCustomerId());
			List<CustomerAddressHistory> customerAddressHistoryList = customerAddressHistoryRepo.findByIdCustomerIdAndIdAddressType(customerId, addressType);
			if (GeneralUtil.isListEmpty(customerAddressHistoryList)) {
				throw new Exception("Customer Address List is null. Invalid Customer Id/Address Type");
			}
			
			List<CustomerAddressHistoryTO> customerAddressHistoryTOList = new ArrayList<>();
			for (CustomerAddressHistory customerAddressHistory : customerAddressHistoryList) {
				CustomerAddressHistoryTO customerAddressHistoryTO = CustomerAddressHistoryTransformerUtil.transformCustomerAddressEntity(customerAddressHistory);
				
				User user = userService.retrieveUserDetails(customerAddressHistoryTO.getUserCode());
				if (user != null) {
					customerAddressHistoryTO.setUsername(user.getUsername());
				}
				
				Region region = regionAccessor.getRegion(customerAddressHistoryTO.getRegion());
				customerAddressHistoryTO.setRegionName(region.getRegionDescription());
				
				Province province = provinceAccessor.getProvince(customerAddressHistoryTO.getProvince(), region.getRegionId());
				customerAddressHistoryTO.setProvinceName(province.getProvinceName());
				
				Municipal municipal = municipalAccessor.getMunicipal(customerAddressHistoryTO.getMunicipal(), province.getProvinceId());
				customerAddressHistoryTO.setMunicipalName(municipal.getMunicipalName());
				
				if (customerAddressHistoryTO != null) {
					customerAddressHistoryTOList.add(customerAddressHistoryTO);
				}
			}
			
			res.setCustomerAddressHistoryList(customerAddressHistoryTOList);
			res.setCustomerCode(customerCode);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return res;
	}

}
