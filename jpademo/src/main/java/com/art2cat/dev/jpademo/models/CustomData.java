package com.art2cat.dev.jpademo.models;

/**
 * @author rorschach.h
 */
public class CustomData implements ICustomData {

    private Integer id;

    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
