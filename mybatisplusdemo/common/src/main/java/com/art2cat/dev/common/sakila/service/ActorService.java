package com.art2cat.dev.common.sakila.service;

import com.art2cat.dev.common.sakila.entity.Actor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.art2cat.dev.common.sakila.FilmData;
import java.util.List;

public interface ActorService extends IService<Actor> {

    List<FilmData> selectFilmsByActorId(Integer id);
}
