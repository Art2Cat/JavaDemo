package com.art2cat.dev.model.impl;

import com.art2cat.dev.model.intf.ICustomEnum;

/**
 * com.art2cat.dev.model
 *
 * @author art2c
 * @date 3/29/2018
 */
public enum TimeZoneEnum implements ICustomEnum {
    UTC_12Y("UTC−12:00, Y"),
    UTC_11Y("UTC−11:00, X"),
    UTC_10W("UTC−10:00, W"),
    UTC_9VH("UTC−09:30, V†"),
    UTC_9V("UTC−09:00, V"),
    UTC_8U("UTC−08:00, U"),
    UTC_7T("UTC−07:00, T"),
    UTC_6S("UTC−06:00, S"),
    UTC_5R("UTC−05:00, R"),
    UTC_4Q("UTC−04:00, Q"),
    UTC_3PH("UTC−03:30, P†"),
    UTC_3P("UTC−03:00, P"),
    UTC_2O("UTC−02:00, O"),
    UTC_1N("UTC−01:00, N"),
    UTC_0Z("UTC±00:00, Z"),
    UTC_1A("UTC+01:00, A"),
    UTC_2B("UTC+02:00, B"),
    UTC_3C("UTC+03:00, C"),
    UTC_3CH("UTC+03:30, C†"),
    UTC_4D("UTC+04:00, D"),
    UTC_4DH("UTC+04:30, D†"),
    UTC_5E("UTC+05:00, E"),
    UTC_5EH("UTC+05:30, E†"),
    UTC_5EQ("UTC+05:45, E*"),
    UTC_6F("UTC+06:00, F"),
    UTC_6FH("UTC+06:30, F†"),
    UTC_7G("UTC+07:00, G"),
    UTC_8H("UTC+08:00, H"),
    UTC_8HH("UTC+08:30, H†"),
    UTC_8HQ("UTC+08:45, H*"),
    UTC_9I("UTC+09:00, I"),
    UTC_9H("UTC+09:30, I†"),
    UTC_10K("UTC+10:00, K"),
    UTC_10H("UTC+10:30, K†"),
    UTC_11L("UTC+11:00, L"),
    UTC_12M("UTC+12:00, M"),
    UTC_12MQ("UTC+12:45, M*"),
    UTC_13M("UTC+13:00, M†"),
    UTC_14M("UTC+14:00, M†");
    
    private String value;
    
    TimeZoneEnum(String value) {
        this.value = value;
    }
    
    @Override
    public String getValue() {
        return value;
    }
    
    public static TimeZoneEnum getKeyByValue(String value) {
        // if no map is available, go back to old way of looping
        for (TimeZoneEnum val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
