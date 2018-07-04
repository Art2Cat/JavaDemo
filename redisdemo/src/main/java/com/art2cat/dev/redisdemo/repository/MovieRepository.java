package com.art2cat.dev.redisdemo.repository;

import com.art2cat.dev.redisdemo.model.Movie;
import java.util.Map;

/**
 * com.art2cat.dev.redisdemo.repository
 *
 * @author rorschach
 * @date 7/4/18
 */
public interface MovieRepository {
    
    Map<Object, Object> findAllMovies();
    
    void add(Movie movie);
    
    void delete(String id);
    
    Movie findMovie(String id);
}
