package com.art2cat.dev.maindemo.sakila.controller;

import com.art2cat.dev.common.sakila.FilmData;
import com.art2cat.dev.common.sakila.service.ActorService;
import com.art2cat.dev.maindemo.sakila.entity.Film;
import com.art2cat.dev.maindemo.sakila.service.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/film/")
@Api(tags = "电影模块")
public class FilmController {

    @Autowired
    private FilmService filmService;
    @Autowired
    private ActorService actorService;

    @GetMapping("getFilmsByActorId/{id}")
    @ApiOperation("获取演员的所有影片")
    @ResponseBody
    public List<FilmData> getFilmsByActorId(
            @PathVariable(value = "id", required = true) Integer id) {
        return actorService.selectFilmsByActorId(id);
    }

    @GetMapping("getFilmById/{id}")
    @ApiOperation("获取影片")
    @ResponseBody
    public Film getFilmById(
            @PathVariable(value = "id", required = true) Integer id) {
        return filmService.getById(id);
    }


}
