package com.soses.audit.api.customer;

import java.util.List;

import com.soses.audit.dto.CustomerAddressTO;
import com.soses.audit.dto.CustomerPhoneTO;
import com.soses.audit.dto.CustomerTO;
import com.soses.audit.dto.UserTO;

public class CustomerProfileResponse extends BaseCustomerResponse {

	private CustomerTO customerTO;
	private List<CustomerPhoneTO> customerPhoneList;
	private List<CustomerAddressTO> customerAddressList;
	private List<UserTO> userList;
	
	public CustomerTO getCustomerTO() {
		return customerTO;
	}
	public List<UserTO> getUserList() {
		return userList;
	}
	public void setUserList(List<UserTO> userList) {
		this.userList = userList;
	}
	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}
	public List<CustomerPhoneTO> getCustomerPhoneList() {
		return customerPhoneList;
	}
	public void setCustomerPhoneList(List<CustomerPhoneTO> customerPhoneList) {
		this.customerPhoneList = customerPhoneList;
	}
	public List<CustomerAddressTO> getCustomerAddressList() {
		return customerAddressList;
	}
	public void setCustomerAddressList(List<CustomerAddressTO> customerAddressList) {
		this.customerAddressList = customerAddressList;
	}
	
	@Override
	public String toString() {
		return "CustomerProfileResponse [customerTO=" + customerTO + ", customerPhoneList=" + customerPhoneList
				+ ", customerAddressList=" + customerAddressList + ", userList=" + userList + "]";
	}
}
