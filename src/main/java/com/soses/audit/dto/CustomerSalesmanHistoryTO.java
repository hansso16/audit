package com.soses.audit.dto;

public class CustomerSalesmanHistoryTO {

	private int customerSalesmanHistoryId;
	private int customerId;
	private String salesmanInitials;
	private String entryTimestamp;
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
	public String getEntryTimestamp() {
		return entryTimestamp;
	}
	public void setEntryTimestamp(String entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}
	@Override
	public String toString() {
		return "CustomerSalesmanHistoryTO [customerSalesmanHistoryId=" + customerSalesmanHistoryId + ", customerId="
				+ customerId + ", salesmanInitials=" + salesmanInitials + ", entryTimestamp=" + entryTimestamp + "]";
	}
}
