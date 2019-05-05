package com.art2cat.dev;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/15/2018
 */
public class IteratorTest {

    @Test
    public void test() {
        BookShelf bookShelf = new BookShelf();

        List<IBook> bookList = new ArrayList<IBook>();
        bookList.add(new Book("Never say never", "unknown", 9.11));
        bookList.add(new Book("Never say never(1)", "unknown", 9.11));
        bookList.add(new Book("Never say never(2)", "unknown", 9.11));
        bookList.add(new Book("Never say never(3)", "unknown", 9.11));
        bookShelf.setBookList(bookList);

        IIterator iIterator = bookShelf.iterator();

        while (iIterator.hasNext()) {
            IBook book = iIterator.next();
            System.out.println(book);
        }
    }

}
