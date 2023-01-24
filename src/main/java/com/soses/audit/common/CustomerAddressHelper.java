package com.soses.audit.common;

import java.time.LocalDateTime;

import com.soses.audit.entity.CustomerAddress;
import com.soses.audit.entity.CustomerAddressHistory;
import com.soses.audit.entity.CustomerAddressHistoryPK;
import com.soses.audit.entity.CustomerAddressPK;

public class CustomerAddressHelper {

	public static boolean isChanged(CustomerAddress dbObj, CustomerAddress requestObj) {
		if (dbObj != null && requestObj != null) {
			if (!dbObj.getStreet().equals(requestObj.getStreet())
					|| dbObj.getMunicipal() != (requestObj.getMunicipal())
					|| dbObj.getProvince() !=(requestObj.getProvince())
					|| dbObj.getRegion() != (requestObj.getRegion())) {
				return true;
			}
		}
		return false;
	}
	
	public static CustomerAddressHistory convertToCustomerAddressHistory(CustomerAddress customerAddress) {
		if (customerAddress == null) {
			return null;
		}
		
		CustomerAddressHistory customerAddressHistory = new CustomerAddressHistory();
		CustomerAddressHistoryPK customerAddressHistoryPK = new CustomerAddressHistoryPK();
		CustomerAddressPK customerAddressPK = customerAddress.getId();
		
		customerAddressHistory.setStreet(customerAddress.getStreet());
		customerAddressHistory.setMunicipal(customerAddress.getMunicipal());
		customerAddressHistory.setProvince(customerAddress.getProvince());
		customerAddressHistory.setRegion(customerAddress.getRegion());
		customerAddressHistory.setZipCode(customerAddress.getZipCode());
		customerAddressHistory.setUserCode(customerAddress.getUserCode());
		
		customerAddressHistoryPK.setCustomerId(customerAddressPK.getCustomerId());
		customerAddressHistoryPK.setAddressType(customerAddressPK.getAddressType());
		customerAddressHistoryPK.setEntryTimestamp(LocalDateTime.now());
		customerAddressHistory.setId(customerAddressHistoryPK);
		
		return customerAddressHistory;
	}
}
