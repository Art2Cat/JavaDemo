package com.art2cat.dev.jpademo.services.controller;

import com.art2cat.dev.jpademo.UserRequest;
import com.art2cat.dev.jpademo.models.User;
import com.art2cat.dev.jpademo.services.intf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * com.art2cat.dev.jpademo.services.controller
 *
 * @author rorschach
 * @date 4/15/18
 */
@RestController
@RequestMapping("/user")
public class UserServiceController {
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") Integer id) {
        return userService.getUser(id);
    }
    
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> insertUser(@Valid @RequestBody UserRequest userRequest, Errors errors) {
        String result;
        if (errors.hasErrors()) {
            // get all errors
            result = errors.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
            
            return ResponseEntity.badRequest().body(result);
        }
        int returnCode = userService.insertUser(composeUser(userRequest));
        return ResponseEntity.ok(returnCode);
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public int deleteUser(@RequestParam(value = "id") Integer id) {
        return userService.deleteUser(id);
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest user, Errors errors) {
        String result;
        if (errors.hasErrors()) {
            // get all errors
            result = errors.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
            
            return ResponseEntity.badRequest().body(result);
        }
        int returnCode = userService.updateUser(composeUser(user));
        return ResponseEntity.ok(returnCode);
    }
    
    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    public List<User> findUsers(@RequestParam(value = "userName") String userName,
        @RequestParam(value = "start") int start, @RequestParam(value = "limit") int limit) {
        return userService.findUsers(userName, start, limit);
    }

    private User composeUser(UserRequest userRequest) {
        var user = new User();
        user.setId(userRequest.getId());
        user.setBirthday(userRequest.getBirthday());
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setMobile(userRequest.getMobile());
        user.setNote(userRequest.getNote());
        return user;
    }
}
