
package com.soses.audit.api.customer;

import org.springframework.web.multipart.MultipartFile;

import com.soses.audit.dto.CustomerTO;

public class CustomerDetailsRequest extends BaseCustomerRequest {

	CustomerTO customerTO;
	
	private MultipartFile storeImage;

	public MultipartFile getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(MultipartFile storeImage) {
		this.storeImage = storeImage;
	}

	public CustomerTO getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}

	@Override
	public String toString() {
		return "CustomerDetailsRequest [customerTO=" + customerTO + ", storeImage=" + storeImage + "]";
	}
}
