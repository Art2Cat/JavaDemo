package com.art2cat.dev.common.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * com.art2cat.dev.jpademo.models
 *
 * @author rorschach
 * @date 4/11/18
 */
@Entity
@Table(name = "parent_entity")
public class ParentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "entity_id")
    private Integer entityId;
    
    @Column(name = "entity_name")
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.EAGER, targetEntity = Subsidiary.class, mappedBy = "parentEntity")
    private List<Subsidiary> subsidiaries;
    
    @Column(name = "stock")
    private String stock;
    
    public ParentEntity() {
    }
    
    public ParentEntity(int id, String name, String stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }
    
    public ParentEntity(Integer id, String name, List<Subsidiary> subsidiaries, String stock) {
        this.id = id;
        this.name = name;
        this.subsidiaries = subsidiaries;
        this.stock = stock;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getEntityId() {
        return entityId;
    }
    
    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
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
    
    @Override
    public String toString() {
        return "ParentEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", subsidiaries=" + subsidiaries +
            ", stock='" + stock + '\'' +
            '}';
    }
}
