package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.model.BookCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * com.art2cat.dev.jpademo.repositories
 *
 * @author rorschach
 * @date 4/13/18
 */
public interface BookCategoryRepository extends CrudRepository<BookCategory, Integer> {
    
}
