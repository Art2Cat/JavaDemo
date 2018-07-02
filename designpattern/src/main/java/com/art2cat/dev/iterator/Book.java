package com.art2cat.dev.iterator;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/15/2018
 */
public class Book implements IBook {
    
    private String bookName;
    private String author;
    private double price;
    
    public Book(String bookName, String author, double price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }
    
    @Override
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
    
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String getBookName() {
        return bookName;
    }
    
    @Override
    public String getAuthor() {
        return author;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Book{" +
            "bookName='" + bookName + '\'' +
            ", author='" + author + '\'' +
            ", price=" + price +
            '}';
    }
}
