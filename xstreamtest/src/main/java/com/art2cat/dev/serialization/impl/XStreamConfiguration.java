/*
 * (C) Quartet FS 2007
 * ALL RIGHTS RESERVED. This material is the CONFIDENTIAL and PROPRIETARY
 * property of Quartet Financial Systems Inc. Any unauthorized use,
 * reproduction or transfer of this material is strictly prohibited
 */
package com.art2cat.dev.serialization.impl;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>XStreamConfiguration</b>
 * <p>
 * XStream configuration class. Designed to be loaded from persisted XML.
 *
 * @author Quartet Financial Systems
 */
@XStreamAlias("XStreamConfiguration")
public class XStreamConfiguration implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4279306677384722865L;

    protected List<ClassAlias> classAliases = new ArrayList<ClassAlias>();
    protected List<FieldAlias> fieldAliases = new ArrayList<FieldAlias>();
    protected List<FieldOmission> fieldOmissions = new ArrayList<FieldOmission>();
    protected List<String> converters = new ArrayList<String>();

    public XStreamConfiguration() {
    }

    public List<ClassAlias> getClassAliases() {
        return classAliases;
    }

    public List<FieldAlias> getFieldAliases() {
        return fieldAliases;
    }

    public void setClassAliases(List<ClassAlias> classAliases) {
        this.classAliases = classAliases;
    }

    public void setFieldAliases(List<FieldAlias> fieldAliases) {
        this.fieldAliases = fieldAliases;
    }

    public List<FieldOmission> getFieldOmissions() {
        return fieldOmissions;
    }

    public void setFieldOmissions(List<FieldOmission> omissions) {
        this.fieldOmissions = omissions;
    }

    public List<String> getConverters() {
        return converters;
    }

    public void setConverters(List<String> converters) {
        this.converters = converters;
    }

}
