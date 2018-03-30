package com.art2cat.dev.model.impl;

import com.art2cat.dev.model.CountryEnum;
import com.art2cat.dev.model.intf.ICountryTimeZone;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
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
@XStreamAlias("CountryTimeZone")
public class CountryTimeZone implements ICountryTimeZone {
    
    @XStreamAsAttribute()
    private String countryName;
    
    private List<TimeZoneEnum> timeZoneEnumList;
    
    public CountryTimeZone(String countryName) {
        this.countryName = countryName;
    }
    
    @XStreamAlias("Country")
    private CountryEnum country;
}
