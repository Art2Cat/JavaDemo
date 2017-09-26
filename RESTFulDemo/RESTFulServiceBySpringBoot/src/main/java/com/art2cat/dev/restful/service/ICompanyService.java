package com.art2cat.dev.restful.service;

import com.art2cat.dev.restful.model.Company;

import java.util.List;

public interface ICompanyService {

	Company findById(long id);

	Company findByName(String name);

	int saveCompany(long id,
	                 String name,
	                 String address,
	                 String city,
	                 String state,
	                 int zipcode,
	                 String country);

	void saveCompany2(Company company);

	void updateCompany(Company company);

	void deleteCompanyById(long id);

	List<Company> findAllCompanies();

	void deleteAllCompanies();

	boolean isCompanyExist(Company company);
}
