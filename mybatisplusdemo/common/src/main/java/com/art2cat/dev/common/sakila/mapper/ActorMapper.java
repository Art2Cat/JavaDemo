package com.art2cat.dev.common.sakila.mapper;

import com.art2cat.dev.common.sakila.entity.Actor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.art2cat.dev.common.sakila.FilmData;
import java.util.List;

public interface ActorMapper extends BaseMapper<Actor> {

    List<FilmData> selectFilms(Integer actorId);
}
