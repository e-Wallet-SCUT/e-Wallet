package com.bruceking.clearing.service;

import com.bruceking.clearing.pojo.Entity;

import java.util.List;

public interface EntityService {
    void addEntity(Entity entity);
    List<Entity> findAllEntity();
    Entity selectById(Integer id);
    void modifyEntity(Entity entity);
}
