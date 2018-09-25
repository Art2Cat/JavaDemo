package com.art2cat.dev.redisdemo.controller;

import com.art2cat.dev.redisdemo.model.Movie;
import com.art2cat.dev.redisdemo.repository.MovieRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * com.art2cat.dev.redisdemo.controller
 *
 * @author rorschach
 * @date 7/4/18
 */
@Slf4j
@Controller
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping(value = "/")
    public String index(Model model) {
        List<Movie> movieList = movieRepository.findAllMovies().entrySet().stream()
            .map(entry -> new Movie((String) entry.getKey(), entry.getValue().toString())).collect(Collectors.toList());
        if (!movieList.isEmpty()) {
            log.info("movie list size: " + movieList.size());
            model.addAttribute("movieList", movieList);
        }
        return "movie";
    }
    
    
    @PostMapping(value = "/")
    public String add(Movie movie) {
        movieRepository.add(movie);
        log.info("movie: " + movie);
        return "redirect:/movie/";
    }
    
    @DeleteMapping(value = "/")
    public ResponseEntity<String> delete(@RequestParam String key) {
        movieRepository.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
