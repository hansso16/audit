package com.soses.audit.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerAddressPK implements Serializable {

	private static final long serialVersionUID = 8094573321811004263L;

	@Column(name="CUSTOMER_ID")
	private String customerId;

	@Column(name="ADDRESS_TYPE")
	private String addressType;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "CustomerAddressPK [customerId=" + customerId + ", addressType=" + addressType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressType, customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAddressPK other = (CustomerAddressPK) obj;
		return Objects.equals(addressType, other.addressType) && Objects.equals(customerId, other.customerId);
	}
}
