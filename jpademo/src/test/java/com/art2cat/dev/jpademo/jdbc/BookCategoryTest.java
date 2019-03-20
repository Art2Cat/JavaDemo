package com.art2cat.dev.jpademo.jdbc;

import com.art2cat.dev.jpademo.configurations.AppConfigs;
import com.art2cat.dev.jpademo.models.Book;
import com.art2cat.dev.jpademo.models.BookCategory;
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
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfigs.class)
public class BookCategoryTest {
    
    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    
//    @Test
    public void test() {
        // save a couple of categories
        BookCategory categoryA = new BookCategory("Category A");
        Set<Book> bookAs = new HashSet<>() {{
            add(new Book("Book A1", categoryA));
            add(new Book("Book A2", categoryA));
            add(new Book("Book A3", categoryA));
        }};
        categoryA.setBooks(bookAs);
        
        BookCategory categoryB = new BookCategory("Category B");
        Set<Book> bookBs = new HashSet<>() {{
            add(new Book("Book B1", categoryB));
            add(new Book("Book B2", categoryB));
            add(new Book("Book B3", categoryB));
        }};
        categoryB.setBooks(bookBs);

        var allCategories = new HashSet<BookCategory>();
        allCategories.add(categoryA);
        allCategories.add(categoryB);

        bookCategoryRepository.saveAll(allCategories);

        // fetch all categories
        bookCategoryRepository.findAll().forEach(i -> System.out.println(i.toString()));
        
    }
}
