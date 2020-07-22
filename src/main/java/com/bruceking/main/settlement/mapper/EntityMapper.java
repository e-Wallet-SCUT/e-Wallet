package com.bruceking.main.settlement.mapper;

import com.bruceking.main.settlement.bean.Entity;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;


@Mapper
public interface EntityMapper {

    public Entity getEntityByEntityId(Integer entity_id);

    public String getPublicKey(Integer entity_id);

    public String getPrivateKey(Integer entity_id);

    public List<Entity> getAllEntity();

    public void updateCurrencyAmount(int entity_id, BigDecimal currency_amount);

    public void updateCurrencyYesterdayStm(int entity_id, BigDecimal currency_yesterday_stm);
}
