package com.art2cat.dev.cache;

import org.springframework.cache.annotation.Cacheable;

public class ErrorCacheManager {

    @Cacheable(value = "errorCacheManager")
    public ErrorEntity get(String name) {
        //省略读取过程，直接返回结果
        System.out.println("reading from disk");
        ErrorEntity errorEntity = new ErrorEntity(1, "succeed");
        errorEntity.setName(name);
        return errorEntity;
    }
}
