package com.art2cat.dev.restful.service;

import com.art2cat.dev.restful.jdbc.JdbcTemplate;
import com.art2cat.dev.restful.model.Company;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyService implements ICompanyService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private String getCompanyByIdTemplate;
    @Autowired
    private String getCompanyByNameTemplate;
    @Autowired
    private String addCompanyTemplate;
    @Autowired
    private String getAllCompanyTemplate;
    @Autowired
    private String deleteCompanyTemplate;
    @Autowired
    private String updateCompanyNameTemplate;
    
    @Override
    public Optional<Company> findById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return Optional
            .ofNullable(jdbcTemplate.queryForObject(getCompanyByIdTemplate, params, (rs, rowNum) -> new Company(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getInt("zipcode"),
                rs.getString("country"))));
    }
    
    @Override
    public Optional<Company> findByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return Optional
            .ofNullable(jdbcTemplate.queryForObject(getCompanyByNameTemplate, params, (rs, rowNum) -> new Company(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getInt("zipcode"),
                rs.getString("country"))));
    }
    
    @Override
    public int saveCompany(long id, String name, String address, String city, String state, int zipcode,
        String country) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("address", address);
        params.put("city", city);
        params.put("state", state);
        params.put("zipcode", zipcode);
        params.put("country", country);
        return jdbcTemplate.update(addCompanyTemplate, params);
    }
    
    @Override
    public void saveCompany2(Company company) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", company.getId());
        params.put("name", company.getName());
        params.put("address", company.getAddress());
        params.put("city", company.getCity());
        params.put("state", company.getState());
        params.put("zipcode", company.getZipcode());
        params.put("country", company.getCountry());
        jdbcTemplate.update(addCompanyTemplate, params);
    }
    
    @Override
    public void updateCompany(Company company) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", company.getId());
        params.put("name", company.getName());
        int result = jdbcTemplate.update(updateCompanyNameTemplate, params);
    }
    
    @Override
    public void deleteCompanyById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(deleteCompanyTemplate, params);
    }
    
    @Override
    public List<Company> findAllCompanies() {
        return jdbcTemplate.query(getAllCompanyTemplate, (rs, rowNum) -> new Company(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("city"),
            rs.getString("state"),
            rs.getInt("zipcode"),
            rs.getString("country")));
    }
    
    @Override
    public void deleteAllCompanies() {
    
    }
    
    @Override
    public boolean isCompanyExist(Company company) {
        return findById(company.getId()).filter(company::equals).isPresent();
    }
}
