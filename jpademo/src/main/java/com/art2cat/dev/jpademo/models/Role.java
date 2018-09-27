package com.art2cat.dev.jpademo.models;

import javax.persistence.*;
import java.util.Date;

/**
 * com.art2cat.dev.jpademo.mybatis.mapper
 *
 * @author rorschach
 * @date 4/15/18
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "create_date", nullable = false, columnDefinition = "datetime default current_timestamp")
    private Date createDate;

    @Column(name = "note")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createDate=" + createDate +
                ", note='" + note + '\'' +
                '}';
    }
}
