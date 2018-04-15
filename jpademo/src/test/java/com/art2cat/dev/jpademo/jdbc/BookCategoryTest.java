package com.art2cat.dev.jpademo.jdbc;

import com.art2cat.dev.jpademo.configurations.AppConfig;
import com.art2cat.dev.jpademo.model.Book;
import com.art2cat.dev.jpademo.model.BookCategory;
import com.art2cat.dev.jpademo.repositories.BookCategoryRepository;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * com.art2cat.dev.jpademo.jdbc
 *
 * @author rorschach
 * @date 4/13/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BookCategoryTest {
    
    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    
    @Test
    public void test() {
        // save a couple of categories
        BookCategory categoryA = new BookCategory("Category A");
        Set<Book> bookAs = new HashSet<Book>() {{
            add(new Book("Book A1", categoryA));
            add(new Book("Book A2", categoryA));
            add(new Book("Book A3", categoryA));
        }};
        categoryA.setBooks(bookAs);
        
        BookCategory categoryB = new BookCategory("Category B");
        Set<Book> bookBs = new HashSet<Book>() {{
            add(new Book("Book B1", categoryB));
            add(new Book("Book B2", categoryB));
            add(new Book("Book B3", categoryB));
        }};
        categoryB.setBooks(bookBs);
        
        bookCategoryRepository.save(new HashSet<BookCategory>() {{
            add(categoryA);
            add(categoryB);
        }});
        
        // fetch all categories
        bookCategoryRepository.findAll().forEach(i -> System.out.println(i.toString()));
        
    }
}
