package com.soses.audit.util;

import com.soses.audit.common.AddressTypeEnum;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerAddressTO;
import com.soses.audit.entity.CustomerAddress;

public class CustomerAddressTransformerUtil {

	public static CustomerAddressTO transformCustomerAddressEntity(CustomerAddress customer) {
		CustomerAddressTO customerAddressTO = null;
		if (customer != null) {
			customerAddressTO = new CustomerAddressTO();
			customerAddressTO.setCustomerId(customer.getId().getCustomerId());
			customerAddressTO.setAddressType(customer.getId().getAddressType());
			customerAddressTO.setAddressTypeDescription(AddressTypeEnum.deriveAddressType(customerAddressTO.getAddressType()));
			customerAddressTO.setStreet(customer.getStreet());
			customerAddressTO.setMunicipal(Integer.toString(customer.getMunicipal()));
			customerAddressTO.setProvince(Integer.toString(customer.getProvince()));
			customerAddressTO.setRegion(Integer.toString(customer.getRegion()));
			customerAddressTO.setZipCode(customer.getZipCode());
			customerAddressTO.setEntryTimestamp(GeneralUtil.formatDateTime(customer.getEntryTimestamp()));
			customerAddressTO.setUserCode(customer.getUserCode());
		}
		return customerAddressTO;
	}
}
