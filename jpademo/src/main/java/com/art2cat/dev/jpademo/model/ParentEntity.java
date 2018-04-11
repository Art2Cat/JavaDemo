package com.art2cat.dev.jpademo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * com.art2cat.dev.jpademo.model
 *
 * @author rorschach
 * @date 4/11/18
 */
@Entity
@Table(name = "parent_entity")
public class ParentEntity {
    
    @Column(name = "entity_id")
    private int id;
    
    @Column(name = "entity_name")
    private String name;
    
    @OneToMany(targetEntity = Subsidiary.class, fetch = FetchType.EAGER, mappedBy = "subsidiary")
    private List<Subsidiary> subsidiaries;
    
    @Column(name = "stock")
    private String stock;
    
    public ParentEntity(int id, String name, String stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }
    
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
    
    public List<Subsidiary> getSubsidiaries() {
        return subsidiaries;
    }
    
    public void setSubsidiaries(List<Subsidiary> subsidiaries) {
        this.subsidiaries = subsidiaries;
    }
    
    public String getStock() {
        return stock;
    }
    
    public void setStock(String stock) {
        this.stock = stock;
    }
}
