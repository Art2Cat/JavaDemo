package com.art2cat.dev.serialization.impl;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.NoArgsConstructor;

/**
 * com.art2cat.dev.serialization.impl
 *
 * @author art2c
 * @date 3/29/2018
 */
@XStreamAlias("fieldOmission")
@NoArgsConstructor
public class FieldOmission {
    
    @XStreamAsAttribute
    protected String type;
    @XStreamAsAttribute
    protected String field;
    
    public FieldOmission(String type, String field) {
        this.type = type;
        this.field = field;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getField() {
        return field;
    }
    
    public void setField(String field) {
        this.field = field;
    }
}
