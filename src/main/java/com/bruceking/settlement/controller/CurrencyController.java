package com.bruceking.settlement.controller;

import com.bruceking.settlement.bean.Currency;
import com.bruceking.settlement.mapper.CurrencyMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CurrencyController {
    @Resource
    CurrencyMapper currencyMapper;

    @GetMapping("/currency")
    public List<Currency> getAllCurrency(){
        return currencyMapper.getAllCurrency();
    }

    @PostMapping("/update_currency")
    public Currency update(Currency currency){
        if(currency.getCurrency_id() != null){
            currencyMapper.updateCurrencyExById(currency);
        }
        else{
            currencyMapper.updateCurrencyExByType(currency);
        }
        return currency;
    }
}
