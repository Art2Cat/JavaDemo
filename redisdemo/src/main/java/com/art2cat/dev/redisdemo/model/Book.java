package com.art2cat.dev.redisdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * com.art2cat.dev.redisdemo
 *
 * @author art2c
 * @date 7/4/2018
 */

@Entity
@ToString
@EqualsAndHashCode
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    
    @Getter
    @Setter
    private String reader;
    
    @Getter
    @Setter
    private String isbn;
    
    @Getter
    @Setter
    private String title;
    
    @Getter
    @Setter
    private String author;
    
    @Getter
    @Setter
    private String description;
    
    
}
