package com.art2cat.dev.jpademo.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * com.art2cat.dev.jpademo.mybatis.mapper
 *
 * @author rorschach
 * @date 4/15/18
 */
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "user_name", nullable = false)
    private String userName;
    
    @Column(name = "birth_day")
    private Date birthDay;
    
    @Column(name = "sex")
    private String sex;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "note")
    private String note;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Date getBirthDay() {
        return birthDay;
    }
    
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", birthDay=" + birthDay +
            ", sex='" + sex + '\'' +
            ", mobile='" + mobile + '\'' +
            ", email='" + email + '\'' +
            ", note='" + note + '\'' +
            '}';
    }
}
