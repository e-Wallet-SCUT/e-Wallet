package com.bruceking.main.settlement.controller;

import com.bruceking.main.settlement.bean.Currency;
import com.bruceking.main.settlement.mapper.CurrencyMapper;
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
    public Boolean update(Currency currency){
        try{
            if(currency.getCurrency_id() != null){
                currencyMapper.updateCurrencyExById(currency);
            }
            else{
                currencyMapper.updateCurrencyExByType(currency);
            }
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
