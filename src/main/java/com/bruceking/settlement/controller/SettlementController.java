package com.bruceking.settlement.controller;

import com.bruceking.settlement.bean.Currency;
import com.bruceking.settlement.bean.Entity;
import com.bruceking.settlement.bean.Transaction;
import com.bruceking.settlement.mapper.CurrencyMapper;
import com.bruceking.settlement.mapper.EntityMapper;
import com.bruceking.settlement.mapper.TransactionMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class SettlementController {
    @Resource
    TransactionMapper transactionMapper;
    @Resource
    EntityMapper entityMapper;
    @Resource
    CurrencyMapper currencyMapper;

    @GetMapping("stm")
    @Transactional
//    @Scheduled(cron = "0 0 1 ? * * ")
    public String stm(){
        List<Currency> currencies = currencyMapper.getAllCurrency();
        double exchangeRate[] = new double[currencies.size()+1];
        for (int i=1;i<=currencies.size();i++){
            exchangeRate[i] = currencies.get(i-1).getCurrency_er();
        }

        List<Entity> entities = entityMapper.getAllEntity();
        int currencyType[] = new int[entities.size()+1];
        double currencyAmount[] = new double[entities.size()+1];
        for (int i=1;i<=entities.size();i++){
            currencyType[i] = entities.get(i-1).getCurrency_id();
            currencyAmount[i] = entities.get(i-1).getCurrency_amount();
        }

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);
        date = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        List<Transaction> txs = transactionMapper.getTxByTime(format.format(date));
        List<Transaction> txs = transactionMapper.getTxByTime("2020-06-18");


        double result[] = new double[entities.size()+1];
        for(Transaction tx : txs){
            int from = tx.getTransaction_from_entity_id(), to = tx.getTransaction_to_entity_id(), type = tx.getTransaction_currency_id();
            double amount = tx.getTransaction_currency_amount();

            result[from] -= amount / exchangeRate[type] * exchangeRate[currencyType[from]];
            result[to] += amount / exchangeRate[type] * exchangeRate[currencyType[to]];
        }

        for(int i=1; i<=entities.size();i++){
            result[i] = Math.round(result[i] * 1000000) * 0.000001d;
            entityMapper.updateCurrencyAmount(i, result[i] + currencyAmount[i]);
            entityMapper.updateCurrencyYesterdayStm(i, result[i]);
        }
        return "success!";
    }
}
