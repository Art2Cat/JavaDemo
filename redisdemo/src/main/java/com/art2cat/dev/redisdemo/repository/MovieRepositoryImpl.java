package com.art2cat.dev.redisdemo.repository;

import com.art2cat.dev.redisdemo.model.Movie;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * com.art2cat.dev.redisdemo.repository
 *
 * @author rorschach
 * @date 7/4/18
 */
@Repository
public class MovieRepositoryImpl implements MovieRepository {
    
    private static final String KEY = "Movie";
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void add(Movie movie) {
        hashOperations.put(KEY, movie.getId(), movie.getName());
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Movie findMovie(String id) {
        return (Movie) hashOperations.get(KEY, id);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Map<Object, Object> findAllMovies() {
        return hashOperations.entries(KEY);
    }
}

