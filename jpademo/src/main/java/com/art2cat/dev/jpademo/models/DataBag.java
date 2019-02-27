package com.art2cat.dev.jpademo.models;


import java.util.ArrayList;
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
import javax.persistence.Transient;

/**
 * @author rorschach.h
 */
@Entity
@Table(name = "data_bag")
public class DataBag implements IDataBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

//    @OneToMany(mappedBy = "dataList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    @Transient
    private List<CustomData> customDataList = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<CustomData> getCustomDataList() {
        return customDataList;
    }

    @Override
    public void setCustomDataList(List<CustomData> customDataList) {
        this.customDataList = customDataList;
    }
}
