package com.soses.audit.util;

import com.soses.audit.common.GeneralUtil;
import com.soses.audit.common.PhoneTypeEnum;
import com.soses.audit.dto.CustomerPhoneTO;
import com.soses.audit.entity.CustomerPhone;

public class CustomerPhoneTransformerUtil {

	public static CustomerPhoneTO transformCustomerPhoneEntity(CustomerPhone customer) {
		CustomerPhoneTO customerPhoneTO = null;
		if (customer != null) {
			customerPhoneTO = new CustomerPhoneTO();
			customerPhoneTO.setCustomerId(customer.getCustomerId());
			customerPhoneTO.setCustomerPhoneId(customer.getCustomerPhoneId());
			customerPhoneTO.setPhoneNumber(customer.getPhoneNumber());
			customerPhoneTO.setPhoneType(customer.getPhoneType());
			customerPhoneTO.setPhoneTypeDescription(PhoneTypeEnum.derivePhoneTypeName(customer.getPhoneType()));
			customerPhoneTO.setEntryTimestamp(GeneralUtil.formatDateTime(customer.getEntryTimestamp()));
			customerPhoneTO.setUsername(customer.getUsername());
		}
		return customerPhoneTO;
	}
	
	public static boolean isChanged(CustomerPhone dbObj, CustomerPhone requestObj) {
		if (dbObj != null && requestObj != null) {
			if (!dbObj.getPhoneNumber().equals(requestObj.getPhoneNumber())
					&& (dbObj.getPhoneType().equals(requestObj.getPhoneType())
						&& dbObj.getCustomerId() == requestObj.getCustomerId()
						&& dbObj.getCustomerPhoneId() == requestObj.getCustomerPhoneId())) {
				return true;
			}
		}
		return false;
	}
}
