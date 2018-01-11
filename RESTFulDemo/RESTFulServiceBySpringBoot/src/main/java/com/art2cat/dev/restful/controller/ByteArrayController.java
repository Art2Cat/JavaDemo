package com.art2cat.dev.restful.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.art2cat.dev.restful.controller
 *
 * @author Rorschach
 * @date 11/01/2018
 */
@RestController
@RequestMapping("/api")
public class ByteArrayController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @RequestMapping(value = "/byteArray/", method = RequestMethod.POST)
    public void postByteArray() {
    
    }
}
