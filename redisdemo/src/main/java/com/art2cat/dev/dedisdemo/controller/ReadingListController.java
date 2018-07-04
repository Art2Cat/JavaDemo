package com.art2cat.dev.dedisdemo.controller;

import com.art2cat.dev.dedisdemo.model.Book;
import com.art2cat.dev.dedisdemo.repository.BookRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.art2cat.dev.dedisdemo.controller
 *
 * @author art2c
 * @date 7/4/2018
 */
@Controller
@RequestMapping("/")
public class ReadingListController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadingListController.class);
    
    @Autowired
    private BookRepository bookRepository;
   
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(
        @PathVariable("reader") String reader, Model model) {
        List<Book> readingList = bookRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            LOGGER.info("reading list size: " + readingList.size());
        }
        return "readingList";
    }
    
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(
        @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookRepository.save(book);
        LOGGER.info("book" + book);
        redisTemplate.convertAndSend("list-key", book.getAuthor());
        return "redirect:/{reader}";
    }
    
}
