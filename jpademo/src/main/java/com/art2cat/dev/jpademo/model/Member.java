package com.art2cat.dev.jpademo.model;

import java.util.Date;

/**
 * com.art2cat.dev.jpademo
 *
 * @author rorschach
 * @date 4/11/18
 */
public class Member {
    
    private int id;
    private String name;
    private int salary;
    private Date birthday;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getSalary() {
        return salary;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
