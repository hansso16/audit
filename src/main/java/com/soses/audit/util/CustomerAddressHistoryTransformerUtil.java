package com.soses.audit.util;

import com.soses.audit.common.AddressTypeEnum;
import com.soses.audit.common.GeneralUtil;
import com.soses.audit.dto.CustomerAddressHistoryTO;
import com.soses.audit.entity.CustomerAddressHistory;

public class CustomerAddressHistoryTransformerUtil {

	public static CustomerAddressHistoryTO transformCustomerAddressEntity(CustomerAddressHistory customer) {
		CustomerAddressHistoryTO customerAddressTO = null;
		if (customer != null) {
			customerAddressTO = new CustomerAddressHistoryTO();
			customerAddressTO.setCustomerId(Integer.parseInt(customer.getId().getCustomerId()));
			customerAddressTO.setAddressType(customer.getId().getAddressType());
			customerAddressTO.setAddressTypeDescription(AddressTypeEnum.deriveAddressType(customerAddressTO.getAddressType()));
			customerAddressTO.setStreet(customer.getStreet());
			customerAddressTO.setMunicipal(Integer.toString(customer.getMunicipal()));
			customerAddressTO.setProvince(Integer.toString(customer.getProvince()));
			customerAddressTO.setRegion(Integer.toString(customer.getRegion()));
			customerAddressTO.setZipCode(customer.getZipCode());
			customerAddressTO.setEntryTimestamp(GeneralUtil.formatDateTime(customer.getId().getEntryTimestamp()));
			customerAddressTO.setUserCode(customer.getUserCode());
			customerAddressTO.setUsername(customer.getUserCode());
		}
		return customerAddressTO;
	}
}
