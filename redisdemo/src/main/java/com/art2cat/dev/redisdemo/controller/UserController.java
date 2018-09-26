package com.art2cat.dev.redisdemo.controller;

import com.art2cat.dev.redisdemo.model.User;
import com.art2cat.dev.redisdemo.repository.UserRepository;
import com.art2cat.dev.redisdemo.service.IUserService;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user_list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserDetail(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveOrUpdateUser(User user) {
        User userDb = null;
        if (Objects.nonNull(user)) {
            if (user.getName() != null && user.getEmail() != null) {

                Optional<User> userOptional = userRepository
                    .findById(user.getId() == null ? 0 : user.getId());
                if (userOptional.isPresent()) {
                    userDb = userService.updateUser(user);
                } else {
                    userDb = userService.addUser(user);
                }
                log.info("saved user: " + userDb);
            }
        }
        if (Objects.isNull(userDb)) {
            return "add_user";
        } else {
            return "redirect:" + userDb.getId();
        }
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.POST, RequestMethod.DELETE})
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        log.info("removed user: {}", id);
        return "redirect:";
    }
}
