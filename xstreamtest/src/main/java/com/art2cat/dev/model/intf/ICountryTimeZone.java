package com.art2cat.dev.model.intf;

import com.art2cat.dev.model.CountryEnum;
import com.art2cat.dev.model.impl.TimeZoneEnum;
import java.util.List;

/**
 * com.art2cat.dev.model.intf
 *
 * @author art2c
 * @date 3/29/2018
 */
public interface ICountryTimeZone {
    
    List<TimeZoneEnum> getTimeZoneEnumList();
    
    void setTimeZoneEnumList(List<TimeZoneEnum> timeZoneEnumList);
    
    String getCountryName();
    
    void setCountryName(String countryName);
    
    CountryEnum getCountry();
    
    void setCountry(CountryEnum countryEnum);
    
}
