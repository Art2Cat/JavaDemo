package com.art2cat.dev.redisdemo.repository;

import com.art2cat.dev.redisdemo.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * com.art2cat.dev.redisdemo.repository
 *
 * @author art2c
 * @date 7/4/2018
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
    List<Book> findByReader(String reader);
}
