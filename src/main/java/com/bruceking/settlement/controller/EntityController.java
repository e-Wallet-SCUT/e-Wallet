package com.bruceking.settlement.controller;

import com.bruceking.settlement.bean.Entity;
import com.bruceking.settlement.mapper.EntityMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EntityController {

    @Resource
    EntityMapper entityMapper;

    @GetMapping("/entity")
    public List<Entity> getEntity(){
        return entityMapper.getAllEntity();
    }
}
