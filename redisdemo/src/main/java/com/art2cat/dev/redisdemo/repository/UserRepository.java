package com.art2cat.dev.redisdemo.repository;

import com.art2cat.dev.redisdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * com.art2cat.dev.redisdemo.repository
 *
 * @author art2c
 * @date 7/12/2018
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u from User u where u.name = :name")
    User getUserByName(@Param("name")String name);
}
