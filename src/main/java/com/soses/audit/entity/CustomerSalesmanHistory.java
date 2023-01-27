package com.soses.audit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_salesman_history", indexes={@Index(name="CUSTOMER_SALESMAN_HISTORY_CUSTOMER_ID_IDX", columnList="CUSTOMER_ID")})
public class CustomerSalesmanHistory implements Serializable {

	private static final long serialVersionUID = -4760446061619583593L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_SALESMAN_HISTORY_ID", unique=true, nullable=false)
	private int customerSalesmanHistoryId;
	@Column(name="CUSTOMER_ID")
	private int customerId;
	@Column(name="SALESMAN_INITIALS", length=10)
	private String salesmanInitials;
	@Column(name="ENTRY_TIMESTAMP", length=10)
	private LocalDateTime entryTimestamp;
	
	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
	}
	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}
	public int getCustomerSalesmanHistoryId() {
		return customerSalesmanHistoryId;
	}
	public void setCustomerSalesmanHistoryId(int customerSalesmanHistoryId) {
		this.customerSalesmanHistoryId = customerSalesmanHistoryId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getSalesmanInitials() {
		return salesmanInitials;
	}
	public void setSalesmanInitials(String salesmanInitials) {
		this.salesmanInitials = salesmanInitials;
	}
	@Override
	public String toString() {
		return "CustomerSalesmanHistory [customerSalesmanHistoryId=" + customerSalesmanHistoryId + ", customerId="
				+ customerId + ", salesmanInitials=" + salesmanInitials + ", entryTimestamp=" + entryTimestamp + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerId, customerSalesmanHistoryId, entryTimestamp, salesmanInitials);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerSalesmanHistory other = (CustomerSalesmanHistory) obj;
		return customerId == other.customerId && customerSalesmanHistoryId == other.customerSalesmanHistoryId
				&& Objects.equals(entryTimestamp, other.entryTimestamp)
				&& Objects.equals(salesmanInitials, other.salesmanInitials);
	}
	
}
