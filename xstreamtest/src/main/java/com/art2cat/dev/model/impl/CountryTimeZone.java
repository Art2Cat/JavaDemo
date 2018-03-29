package com.art2cat.dev.model.impl;

import com.art2cat.dev.model.intf.ICountryTimeZone;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * com.art2cat.dev.model
 *
 * @author art2c
 * @date 3/29/2018
 */
@Setter
@Getter
@NoArgsConstructor
public class CountryTimeZone implements ICountryTimeZone {
    
    private String countryName;
    
    private List<TimeZoneEnum> timeZoneEnumList;
    
    public CountryTimeZone(String countryName) {
        this.countryName = countryName;
    }
}
