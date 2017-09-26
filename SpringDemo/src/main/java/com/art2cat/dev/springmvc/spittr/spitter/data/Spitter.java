package com.art2cat.dev.springmvc.spittr.spitter.data;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

    @NotNull
    @Size(min = 5, max = 16)
    private String userName;

    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    @NotNull
    @Size(min = 5, max = 25)
    private String lastName;

    @NotNull
    @Size(min = 5, max = 25)
    private String firstName;
    private Long id;

    private String fullName;

    private String email;
    private boolean isUpdateByEmail;

    public Spitter(Long id, String userName, String password,
                   String fullName, String email, boolean isUpdateByEmail) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.isUpdateByEmail = isUpdateByEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUpdateByEmail() {
        return isUpdateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        isUpdateByEmail = updateByEmail;
    }

    public Long getId() {
        return id;
    }

    public Spitter(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Spitter(String userName, String registerTime, String firstName, String lastName) {
        this(null, userName, registerTime, firstName, lastName);
    }

    public Spitter(Long id, String userName, String password, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "userName", "password");
    }
}
