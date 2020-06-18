package com.bruceking.settlement.mapper;

import com.bruceking.settlement.bean.Currency;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CurrencyMapper {
    public List<Currency> getAllCurrency();

    public void updateCurrencyExById(Currency currency);

    public void updateCurrencyExByType(Currency currency);

}
