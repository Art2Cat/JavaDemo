package com.art2cat.dev.effective_java;

import java.util.Objects;

/**
 * @author rorschach.h
 */
public class EqualsObject {

    private String value;

    public EqualsObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof EqualsObject) {
            EqualsObject that = (EqualsObject) o;
            return value.equals(that.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
