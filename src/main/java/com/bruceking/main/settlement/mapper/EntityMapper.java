package com.bruceking.main.settlement.mapper;

import com.bruceking.main.settlement.bean.Entity;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;


@Mapper
public interface EntityMapper {

    public List<Entity> getEntityByEntityId(Integer entity_id);

    public String getPublicKey(Integer entity_id);

    public String getPrivateKey(Integer entity_id);

    public List<Entity> getAllEntity();

    public void insertEntity(Entity entity);

    public void updateCurrencyAmount(int entity_id, BigDecimal currency_amount);

    public void updateCurrencyYesterdayStm(int entity_id, BigDecimal currency_yesterday_stm);

    public BigDecimal getCurrencyUsed(int entity_id);

    public void updateCurrencyUsed(int entity_id, BigDecimal used);


}
