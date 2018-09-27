package com.art2cat.dev.redisdemo.repository;

import com.art2cat.dev.redisdemo.model.RedisMsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<RedisMsg, Integer> {

}
