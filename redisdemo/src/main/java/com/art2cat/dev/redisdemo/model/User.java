package com.art2cat.dev.redisdemo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * com.art2cat.dev.redisdemo.model
 *
 * @author art2c
 * @date 7/12/2018
 */
@ToString
@EqualsAndHashCode
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;
    
    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    @Column(name = "email", unique = true)
    private String email;
    
}
