package com.art2cat.dev.restful.model;

import com.art2cat.dev.restful.utils.AESUtils;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    public User() {
//		id=0;
    }

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = AESUtils.encrypt(username, password);
    }

    public User(long id, String username, String password, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
