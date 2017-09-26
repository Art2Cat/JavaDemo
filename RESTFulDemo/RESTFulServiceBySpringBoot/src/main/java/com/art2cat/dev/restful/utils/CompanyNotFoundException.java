package com.art2cat.dev.restful.utils;

public class CompanyNotFoundException extends RuntimeException {
	private long companyId;
	private String companyName;

	public CompanyNotFoundException(long companyId) {
		this.companyId = companyId;
	}

	public CompanyNotFoundException(String companyName) {
		this.companyName = companyName;
	}

	public long getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}
}
