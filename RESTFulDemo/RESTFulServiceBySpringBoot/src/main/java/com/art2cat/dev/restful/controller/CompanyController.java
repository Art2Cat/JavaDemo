package com.art2cat.dev.restful.controller;

import com.art2cat.dev.restful.model.Company;
import com.art2cat.dev.restful.service.CompanyService;
import com.art2cat.dev.restful.utils.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class CompanyController {
	private static Pattern NUMERIC_PATTERN = Pattern.compile("^[-+]?[\\d]*$");
	@Autowired
	CompanyService companyService;

	@RequestMapping(value = "/CompanyService", method = RequestMethod.GET)
	public List<Company> getAllCompanies() {
		return companyService.findAllCompanies();
	}

	@RequestMapping(value = "/CompanyService/{idOrName}", method = RequestMethod.GET)
	public Company getCompany(@NotNull @PathVariable("idOrName") String idOrName) {
		Optional<Company> company;

			if (isNumeric(idOrName)) {
				company = companyService.findById(Long.valueOf(idOrName));
			} else {
				company = companyService.findByName(idOrName);
			}

		if (!company.isPresent()) {
			throw new CompanyNotFoundException(idOrName);
		}

		return company.get();
	}

	//http://localhost:8080/Api/CompanyService/save?id=11111&name=test&address=test%20street&city=shanghai&state=shanghai&zipcode=199&country=cn
	@RequestMapping(value = "/CompanyService/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String saveCompany(@RequestParam(value = "id") long id,
	                          @RequestParam(value = "name") String name,
	                          @RequestParam(value = "address") String address,
	                          @RequestParam(value = "city") String city,
	                          @RequestParam(value = "state") String state,
	                          @RequestParam(value = "zipcode") int zipcode,
	                          @RequestParam(value = "country") String country) {

		int result = companyService.saveCompany(id, name, address, city, state, zipcode, country);
		if (result == 1) {
			return String.format("save company %s succeed!", name);
		} else {
			return String.format("save company %s failed!", name);
		}
	}

	@RequestMapping(value = "/CompanyService/save2", method = RequestMethod.POST)
	public ResponseEntity<?> saveCompany2(@RequestBody Company company, UriComponentsBuilder ucBuilder) {

		if (companyService.isCompanyExist(company)) {
			return new ResponseEntity<>("Unable to create. A User with name " +
					company.getName() + " already exist.", HttpStatus.CONFLICT);
		}
		companyService.saveCompany2(company);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Api/CompanyService/{id}").buildAndExpand(company.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	//http://localhost:8080/Api/CompanyService/delete?id=10006
	@RequestMapping(value = "/CompanyService/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCompany(@RequestParam(value = "id") long id) {

		companyService.deleteCompanyById(id);
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}


	@RequestMapping(value = "/CompanyService/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCompany(@PathVariable("id") long id, @RequestBody Company company) {

		Optional<Company> currentCompany = companyService.findById(id);

		if (!currentCompany.isPresent()) {
			return new ResponseEntity<>(new CompanyNotFoundException("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		Company company1 = currentCompany.get();
		company1.setName(company.getName());
		companyService.updateCompany(company1);
		return new ResponseEntity<>(company1, HttpStatus.OK);
	}

	@ExceptionHandler(CompanyNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error CompanyNotFound(CompanyNotFoundException e) {
		String name = e.getCompanyName();
		String message = "Company [%name] not found";
		return new Error(String.format(message, name));
	}

	private static boolean isNumeric(String str) {
		return NUMERIC_PATTERN.matcher(str).matches();
	}
}
