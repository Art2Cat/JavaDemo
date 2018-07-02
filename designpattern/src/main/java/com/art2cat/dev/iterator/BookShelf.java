package com.art2cat.dev.iterator;

import java.util.List;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/15/2018
 */
public class BookShelf implements IAggregate {
    
    private List<IBook> bookList;
    
    public List<IBook> getBookList() {
        return bookList;
    }
    
    public void setBookList(List<IBook> bookList) {
        this.bookList = bookList;
    }
    
    @Override
    public IIterator iterator() {
        return new BookShelfIterator(this);
    }
}
