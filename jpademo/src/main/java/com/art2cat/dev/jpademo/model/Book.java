package com.art2cat.dev.jpademo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * com.art2cat.dev.jpademo.model
 *
 * @author rorschach
 * @date 4/13/18
 */
@Entity
@Table(name = "book")
public class Book {
    
    private int id;
    private String name;
    private BookCategory bookCategory;
    
    public Book() {
    
    }
    
    public Book(String name) {
        this.name = name;
    }
    
    public Book(String name, BookCategory bookCategory) {
        this.name = name;
        this.bookCategory = bookCategory;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    @ManyToOne
    @JoinColumn(name = "book_category_id")
    public BookCategory getBookCategory() {
        return bookCategory;
    }
    
    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
