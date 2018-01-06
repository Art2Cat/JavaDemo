package com.art2cat.dev.database.db;


import com.art2cat.dev.database.jpaspringdata.domain.Spitter;
import java.util.List;

public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();

}
