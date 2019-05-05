package com.art2cat.dev;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/15/2018
 */
public class BookShelfIterator implements IIterator {

    private final BookShelf bookshelf;
    private int index;

    public BookShelfIterator(BookShelf bookshelf) {
        this.bookshelf = bookshelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookshelf.getBookList().size();
    }

    @Override
    public IBook next() {
        IBook book = bookshelf.getBookList().get(index);
        index++;
        return book;
    }
}
