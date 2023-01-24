package com.soses.audit.api;

public class BaseSearchRequest {

	private String search;
	
	private String size;
	
	private String page;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "BaseSearchRequest [search=" + search + ", size=" + size + ", page=" + page + "]";
	}
}
