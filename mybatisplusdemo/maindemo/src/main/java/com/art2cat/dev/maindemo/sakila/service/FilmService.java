package com.art2cat.dev.maindemo.sakila.service;

import com.art2cat.dev.common.sakila.FilmData;
import com.art2cat.dev.maindemo.sakila.entity.Film;
import java.util.List;

public interface FilmService {

    List<FilmData> getFilmsByActorId(Integer id);

    Film getById(Integer id);
}
