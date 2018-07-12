package com.art2cat.dev.redisdemo.controller;

import com.art2cat.dev.redisdemo.model.User;
import com.art2cat.dev.redisdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.art2cat.dev.redisdemo.controller
 *
 * @author art2c
 * @date 7/12/2018
 */
@Controller
@Slf4j
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/user/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user_list";
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @Cacheable("user-key")
    public String getUserDetail(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.getOne(id);
        log.info("get user: " + user);
        model.addAttribute("user", user);
        return "user";
    }
    
    @RequestMapping(value = "/user/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String addToReadingList(User user) {
        user = userRepository.save(user);
        log.info("saved user: " + user);
        return "add_user";
    }
    
}
