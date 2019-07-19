package com.art2cat.dev.common.sakila.service.impl;

import com.art2cat.dev.common.sakila.entity.Actor;
import com.art2cat.dev.common.sakila.mapper.ActorMapper;
import com.art2cat.dev.common.sakila.service.ActorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.art2cat.dev.common.sakila.FilmData;
import java.util.Collections;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service("actorService")
@Log4j2
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor> implements ActorService {

    @Override
    public List<FilmData> selectFilmsByActorId(Integer id) {
        try {
            log.info("id=" + id);
            return baseMapper.selectFilms(id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }
}
