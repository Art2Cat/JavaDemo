package com.art2cat.dev.jpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * com.art2cat.dev.jpademo.model
 *
 * @author rorschach
 * @date 4/11/18
 */
@Entity
@Table(name = "subsidiary")
public class Subsidiary {
    
    @Id
    @GeneratedValue
    @Column(name = "sub_id")
    private Integer id;
    
    @Column(name = "subsidiary_name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "entity_id")
    private ParentEntity parentEntity;
    
    public Subsidiary() {
    }
    
    public Subsidiary(int id, String name, ParentEntity parentEntity) {
        this.id = id;
        this.name = name;
        this.parentEntity = parentEntity;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ParentEntity getParentEntity() {
        return parentEntity;
    }
    
    public void setParentEntity(ParentEntity parentEntity) {
        this.parentEntity = parentEntity;
    }
    
    @Override
    public String toString() {
        return "Subsidiary{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", parentEntity=" + parentEntity +
            '}';
    }
}
