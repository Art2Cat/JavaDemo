
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
@XStreamAlias("fieldAlias")
@NoArgsConstructor
public class FieldAlias {
    
    @XStreamAsAttribute
    protected String type;
    @XStreamAsAttribute
    protected String field;
    @XStreamAsAttribute
    protected String alias;
    
    public FieldAlias(String type, String field, String alias) {
        this.type = type;
        this.field = field;
        this.alias = alias;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getAlias() {
        return alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public String getField() {
        return field;
    }
    
    public void setField(String field) {
        this.field = field;
    }
}
