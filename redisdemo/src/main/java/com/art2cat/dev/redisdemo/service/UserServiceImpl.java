package com.art2cat.dev.redisdemo.service;

import com.art2cat.dev.redisdemo.model.User;
import com.art2cat.dev.redisdemo.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    @Cacheable(value = "allUserCache", unless = "#result.size() == 0")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "userCache", key = "#id", unless = "#result == null")
    public User getUserById(@NotNull Integer id) {
        Objects.requireNonNull(id, "user id can not be null");
        var user = userRepository.findById(id).orElse(null);
        log.info("get user: " + user);
        return user;
    }

    @Override
    @Caching(
        put = {@CachePut(value = "userCache", key = "#user.id", unless = "#result == null")},
        evict = {@CacheEvict(value = "allUserCache", allEntries = true)}
    )
    public User addUser(@NotNull User user) {
        Objects.requireNonNull(user, "user can not be null!");
        var userDb = userRepository.save(user);
        log.info("saved user: " + userDb.getName());
        return userDb;
    }

    @Override
    @Caching(
        put = {@CachePut(value = "userCache", key = "#user.id")},
        evict = {@CacheEvict(value = "allUserCache", allEntries = true)}
    )
    public User updateUser(@NotNull User user) {
        Objects.requireNonNull(user, "user can not be null!");
        var userDb = userRepository.save(user);
        log.info("updated user: " + userDb.getName());
        return userDb;
    }

    @Override
    @Caching(evict = {
        @CacheEvict(value = "userCache", key = "#id"),
        @CacheEvict(value = "allUserCache", allEntries = true)
    })
    public void deleteUserById(@NotNull Integer id) {
        Objects.requireNonNull(id, "user id can not be null");
        userRepository.deleteById(id);
        log.info("removed user: {}", id);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
