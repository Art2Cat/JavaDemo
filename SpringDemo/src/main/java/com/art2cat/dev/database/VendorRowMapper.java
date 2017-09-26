package com.art2cat.dev.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorRowMapper implements RowMapper<Vendor> {
    @Override
    public Vendor mapRow(ResultSet rs, int i) throws SQLException {
        Vendor vendor = new Vendor();
        vendor.setId(rs.getLong("VEND_ID"));
        vendor.setName(rs.getString("VEND_NAME"));
        vendor.setAddress(rs.getString("VEND_ADDRESS"));
        vendor.setCity(rs.getString("VEND_CITY"));
        vendor.setState(rs.getString("VEND_STATE"));
        vendor.setZip(rs.getString("VEND_ZIP"));
        vendor.setCountry(rs.getString("VEND_COUNTRY"));
        return vendor;
    }
}
