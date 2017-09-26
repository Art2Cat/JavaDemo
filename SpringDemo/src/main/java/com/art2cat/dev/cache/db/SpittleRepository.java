package com.art2cat.dev.cache.db;

import java.util.List;

import com.art2cat.dev.database.jpaspringdata.domain.Spittle;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface SpittleRepository {

    long count();

    @Cacheable("ehcacheTest")
    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    @Cacheable("ehcacheTest")
    Spittle findOne(long id);

    @CachePut(value = "ehcacheTest", key = "#result.id")
    Spittle save(Spittle spittle);

    @Cacheable("ehcacheTest")
    List<Spittle> findBySpitterId(long spitterId);

    @CacheEvict(value = "ehcacheTest", condition = "")
    void delete(long id);

}
