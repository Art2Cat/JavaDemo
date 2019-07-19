package com.art2cat.dev.common.sakila.controller;

import com.art2cat.dev.common.sakila.entity.Actor;
import com.art2cat.dev.common.sakila.service.ActorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actor/")
@Api(tags = "演员模块")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("getActor/{id}")
    @ApiOperation("获取演员信息")
    @ResponseBody
    public Actor getActor(@PathVariable(value = "id", required = true) Integer id) {
        return actorService.getById(id);
    }


}
