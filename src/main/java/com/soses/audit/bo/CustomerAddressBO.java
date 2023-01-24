package com.soses.audit.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.audit.cache.municipal.MunicipalAccessor;
import com.soses.audit.cache.province.ProvinceAccessor;
import com.soses.audit.cache.region.RegionAccessor;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerAddressTO;
import com.soses.audit.entity.CustomerAddress;
import com.soses.audit.entity.Municipal;
import com.soses.audit.entity.Province;
import com.soses.audit.entity.Region;
import com.soses.audit.repository.CustomerAddressRepository;
import com.soses.audit.util.CustomerAddressTransformerUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerAddressBO {

	private static final Logger log = LoggerFactory.getLogger(CustomerAddressBO.class);
	
	private CustomerAddressRepository customerAddressRepo;
	
	private RegionAccessor regionAccessor;
	
	private ProvinceAccessor provinceAccessor;
	
	private MunicipalAccessor municipalAccessor;

	public CustomerAddressBO(CustomerAddressRepository customerAddressRepo, RegionAccessor regionAccessor
			, ProvinceAccessor provinceAccessor, MunicipalAccessor municipalAccessor) {
		super();
		this.customerAddressRepo = customerAddressRepo;
		this.regionAccessor = regionAccessor;
		this.provinceAccessor = provinceAccessor;
		this.municipalAccessor = municipalAccessor;
	}

	public List<CustomerAddressTO> retrieveCustomerAddressList(int customerId) throws Exception {
		
		List<CustomerAddressTO> list = null;
		try {
			List<CustomerAddress> customerAddressList = customerAddressRepo.findByIdCustomerId(Integer.toString(customerId));
			if (!GeneralUtil.isListEmpty(customerAddressList)) {
				list = new ArrayList<>();
				for (CustomerAddress customerAddress : customerAddressList) {
					CustomerAddressTO to = CustomerAddressTransformerUtil.transformCustomerAddressEntity(customerAddress);
					
					Region region = regionAccessor.getRegion(Integer.toString(customerAddress.getRegion()));
					to.setRegionName(region.getRegionDescription());
					
					Province province = provinceAccessor.getProvince(Integer.toString(customerAddress.getProvince()), region.getRegionId());
					to.setProvinceName(province.getProvinceName());
					
					Municipal municipal = municipalAccessor.getMunicipal(Integer.toString(customerAddress.getMunicipal()), province.getProvinceId());
					to.setMunicipalName(municipal.getMunicipalName());
					
					list.add(to);
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception("retrieveCustomerAddressList(int customerId): Error retrieving Customer Address Details");
		}
		return list;
	}
	
	public List<CustomerAddress> getCustomerAddressList(int customerId) throws Exception {
		
		List<CustomerAddress> list = null;
		try {
			list = customerAddressRepo.findByIdCustomerId(Integer.toString(customerId));
			if (GeneralUtil.isListEmpty(list)) {
				// error
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception("retrieveCustomerAddressList(int customerId): Error retrieving Customer Address Details");
		}
		return list;
	}
}
