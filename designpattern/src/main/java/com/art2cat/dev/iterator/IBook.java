package com.art2cat.dev.iterator;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/15/2018
 */
public interface IBook {
    
    void setBookName(String bookName);
    
    void setAuthor(String author);
    
    void setPrice(double price);
    
    String getBookName();
    
    String getAuthor();
    
    double getPrice();
}
