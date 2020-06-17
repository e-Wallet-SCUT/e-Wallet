package com.bruceking.clearing.service.impl;

import com.bruceking.clearing.mapper.EntityMapper;
import com.bruceking.clearing.pojo.Entity;
import com.bruceking.clearing.pojo.EntityExample;
import com.bruceking.clearing.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityMapper entityMapper;

    /**
     * 添加金融实体
     * @param entity
     */
    @Override
    public void addEntity(Entity entity) {

    }

    /**
     * 查询全部金融实体
     * @return 返回金融实体的集合
     */
    @Override
    public List<Entity> findAllEntity() {
        EntityExample entityExample = new EntityExample();
        return this.entityMapper.selectByExample(entityExample);
    }

    /**
     * 根据id查询金融实体
     * @return
     */
    @Override
    public Entity selectById(Integer id) {
        return this.entityMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新金融实体
     * @param entity
     */
    @Override
    @Transactional
    public void modifyEntity(Entity entity) {
        this.entityMapper.updateByPrimaryKey(entity);
    }


}
