package com.art2cat.dev.jpademo.models;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author rorschach.h
 */
public class Group extends Organization {

    private String groupCode;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Group)) {
            return false;
        }
        Group group = (Group) o;
        return Objects.equals(groupCode, group.groupCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Group.class.getSimpleName() + "[", "]")
            .add("groupCode='" + groupCode + "'")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("phone='" + phone + "'")
            .add("fax='" + fax + "'")
            .toString();
    }
}
