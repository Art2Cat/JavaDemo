
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
@XStreamAlias("classAlias")
@NoArgsConstructor
public class ClassAlias {

    @XStreamAsAttribute
    protected String type;
    @XStreamAsAttribute
    protected String alias;


    public ClassAlias(String type, String alias) {
        this.type = type;
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
}
