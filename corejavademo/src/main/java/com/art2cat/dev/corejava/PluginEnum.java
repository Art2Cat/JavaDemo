package com.art2cat.dev.corejava;

/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 3/11/18
 */
public enum PluginEnum {
    DatePlugin("com.art2cat.dev.DateEnum"),
    DateCountPlugin("com.art2cat.dev.DateCountEnum"),
    TimeZonePlugin("com.art2cat.dev.TimeZoneEnum"),
    MarketPlugin("com.art2cat.dev.MarketEnum"),
    LendeTypePlugin("com.art2cat.dev.LenderTypeEnum");
    
    private String typeKey;
    
    PluginEnum(String typeKey) {
        this.typeKey = typeKey;
    }
    
    public String getTypeKey() {
        return typeKey;
    }
}
