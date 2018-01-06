package com.art2cat.dev.springmvc.spittr.spitter.data;

public interface ISpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String name);
}
