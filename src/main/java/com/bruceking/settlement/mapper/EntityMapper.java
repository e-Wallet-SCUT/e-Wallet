package com.bruceking.settlement.mapper;

import com.bruceking.settlement.bean.Entity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface EntityMapper {

    public Entity getEntityByEntityId(Integer entity_id);

    public List<Entity> getAllEntity();

    public void updateCurrencyAmount(int entity_id, double currency_amount);

    public void updateCurrencyYesterdayStm(int entity_id, double currency_yesterday_stm);
}
