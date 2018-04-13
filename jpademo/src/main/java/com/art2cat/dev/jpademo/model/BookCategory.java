package com.art2cat.dev.jpademo.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * com.art2cat.dev.jpademo.model
 *
 * @author rorschach
 * @date 4/13/18
 */
@Entity
@Table(name = "book_category")
public class BookCategory {
    
    private int id;
    private String name;
    private Set<Book> books;
    
    public BookCategory() {
    
    }
    
    public BookCategory(String name) {
        this.name = name;
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
    
    @OneToMany(mappedBy = "bookCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Book> getBooks() {
        return books;
    }
    
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    
    @Override
    public String toString() {
        String result = String.format(
            "Category[id=%d, name='%s']%n",
            id, name);
        if (books != null) {
            for (Book book : books) {
                result += String.format(
                    "Book[id=%d, name='%s']%n",
                    book.getId(), book.getName());
            }
        }
        
        return result;
    }
}
