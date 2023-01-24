package com.soses.audit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The Class EmployeeAddressPK.
 *
 * @author hso
 * @since 19 Nov 2021
 */
@Embeddable
public class CustomerAddressHistoryPK implements Serializable {

	private static final long serialVersionUID = 7286351108679372094L;

	@Column(name="CUSTOMER_ID")
	private String customerId;

	@Column(name="ADDRESS_TYPE")
	private String addressType;
	
	@Column(name="ENTRY_TIMESTAMP")
	private LocalDateTime entryTimestamp;

	public CustomerAddressHistoryPK() {
		super();
	}

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

	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
	}

	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	@Override
	public String toString() {
		return "CustomerAddressHistoryPK [customerId=" + customerId + ", addressType=" + addressType
				+ ", entryTimestamp=" + entryTimestamp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressType, customerId, entryTimestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAddressHistoryPK other = (CustomerAddressHistoryPK) obj;
		return Objects.equals(addressType, other.addressType) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(entryTimestamp, other.entryTimestamp);
	}
}
