package com.art2cat.dev.restful.service;

import com.art2cat.dev.restful.model.Company;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface ICompanyService {

	Optional<Company> findById(@NotNull long id);

	Optional<Company> findByName(@NotNull String name);

	int saveCompany(@NotNull long id,
	                 String name,
	                 String address,
	                 String city,
	                 String state,
	                 int zipcode,
	                 String country);

	void saveCompany2(@NotNull Company company);

	void updateCompany(@NotNull Company company);

	void deleteCompanyById(@NotNull long id);

	List<Company> findAllCompanies();

	void deleteAllCompanies();

	boolean isCompanyExist(@NotNull Company company);
}
