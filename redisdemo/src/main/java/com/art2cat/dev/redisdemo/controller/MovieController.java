package com.art2cat.dev.redisdemo.controller;

import com.art2cat.dev.redisdemo.model.Movie;
import com.art2cat.dev.redisdemo.repository.MovieRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.art2cat.dev.redisdemo.controller
 *
 * @author rorschach
 * @date 7/4/18
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
    
    @GetMapping(value = "/keys")
    @ResponseBody
    public Map<Object, Object> keys() {
        return movieRepository.findAllMovies();
    }
    
    @PostMapping(value = "/values")
    @ResponseBody
    public Map<String, String> findAll() {
        Map<Object, Object> aa = movieRepository.findAllMovies();
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : aa.entrySet()) {
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<String> add(
        @RequestParam String key,
        @RequestParam String value) {
        
        Movie movie = new Movie(key, value);
        
        movieRepository.add(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam String key) {
        movieRepository.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
