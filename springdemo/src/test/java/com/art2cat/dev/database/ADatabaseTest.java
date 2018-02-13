package com.art2cat.dev.database;

import org.junit.Before;

public abstract class ADatabaseTest {
    
    public Vendor vendor;
    
    @Before
    public void _init() {
        vendor = new Vendor();
        vendor.setCountry("US");
        vendor.setZip("1233");
        vendor.setState("CA");
        vendor.setCity("SF");
        vendor.setAddress("US TEST address");
        vendor.setName("US VENDOR");
        vendor.setId(12222L);
    }
}
