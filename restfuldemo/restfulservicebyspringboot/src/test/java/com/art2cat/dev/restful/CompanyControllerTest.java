package com.art2cat.dev.restful;

import com.art2cat.dev.restful.jdbc.JdbcTemplate;
import com.art2cat.dev.restful.model.Company;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompanyControllerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private String getAllCompanyTemplate;
    @Autowired
    private String getCompanyByNameTemplate;

    @Test
    public void testGetAllCompany() {
        List<Company> test = jdbcTemplate.query(getAllCompanyTemplate, (rs, rowNum) -> new Company(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("city"),
            rs.getString("state"),
            rs.getInt("zipcode"),
            rs.getString("country")));
        Assert.assertNotNull(test);
        Assert.assertEquals(5, test.size());
    }

    @Test
    public void testGetCompanyByName() {

        Map<String, Object> params = new HashMap<>();
        params.put("name", "tes");
        Company company = jdbcTemplate
            .queryForObject(getCompanyByNameTemplate, params, (rs, rowNum) -> new Company(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getInt("zipcode"),
                rs.getString("country")));
        Assert.assertNotNull(company);
    }
}
