package com.art2cat.dev.redisdemo.controller;

import com.art2cat.dev.redisdemo.model.Book;
import com.art2cat.dev.redisdemo.repository.BookRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.art2cat.dev.redisdemo.controller
 *
 * @author art2c
 * @date 7/4/2018
 */
@Slf4j
@Controller
@RequestMapping("/")
public class ReadingListController {
    
    //private static final Logger LOGGER = LoggerFactory.getLogger(ReadingListController.class);
    
    @Autowired
    private BookRepository bookRepository;
    
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(
        @PathVariable("reader") String reader, Model model) {
        List<Book> readingList = bookRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            log.info("reading list size: " + readingList.size());
        }
        return "readingList";
    }
    
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(
        @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookRepository.save(book);
        log.info("book" + book);
        return "redirect:/{reader}";
    }
    
}
