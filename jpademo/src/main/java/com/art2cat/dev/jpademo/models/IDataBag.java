package com.art2cat.dev.jpademo.models;

import java.util.List;

/**
 * @author rorschach.h
 */
public interface IDataBag {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    List<CustomData> getCustomDataList();

    void setCustomDataList(List<CustomData> customDataList);

}
