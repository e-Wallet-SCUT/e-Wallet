package com.bruceking.clearing.mapper;

import com.bruceking.clearing.pojo.Entity;
import com.bruceking.clearing.pojo.EntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



public interface EntityMapper {
    long countByExample(EntityExample example);

    int deleteByExample(EntityExample example);

    int deleteByPrimaryKey(Integer entityId);

    int insert(Entity record);

    int insertSelective(Entity record);

    List<Entity> selectByExample(EntityExample example);

    Entity selectByPrimaryKey(Integer entityId);

    int updateByExampleSelective(@Param("record") Entity record, @Param("example") EntityExample example);

    int updateByExample(@Param("record") Entity record, @Param("example") EntityExample example);

    int updateByPrimaryKeySelective(Entity record);

    int updateByPrimaryKey(Entity record);



}