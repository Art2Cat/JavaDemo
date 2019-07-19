package com.art2cat.dev.maindemo.sakila.service.impl;

import com.art2cat.dev.common.sakila.FilmData;
import com.art2cat.dev.maindemo.sakila.service.FilmService;
import com.art2cat.dev.maindemo.sakila.entity.Film;
import com.art2cat.dev.maindemo.sakila.mapper.FilmMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public List<FilmData> getFilmsByActorId(Integer id) {
        System.out.println(id);
//        return actorMapper.getFilms(id);
        return null;
    }

    @Override
    public Film getById(Integer id) {
        return filmMapper.selectById(id);
    }
}
