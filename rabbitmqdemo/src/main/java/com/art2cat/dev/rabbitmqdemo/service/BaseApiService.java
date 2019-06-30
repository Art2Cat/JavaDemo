package com.art2cat.dev.rabbitmqdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseApiService {

    ThreadLocal<ObjectMapper> mapperThreadLocal = new ThreadLocal<>();

    protected Optional<String> serialize(Object object) {
        ObjectMapper objectMapper = mapperThreadLocal.get();
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapperThreadLocal.set(objectMapper);
        }
        try {
            return Optional.of(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    protected Optional<Object> deserialize(String json, Class<?> clazz) {
        ObjectMapper objectMapper = mapperThreadLocal.get();
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapperThreadLocal.set(objectMapper);
        }
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            return Optional.of(objectMapper.readValue(json, clazz));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
