package com.bruceking.settlement.controller;

import com.bruceking.settlement.bean.Transaction;
import com.bruceking.settlement.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

    @Resource
    TransactionMapper transactionMapper;

    @GetMapping("/tx/{Entity_id}")
//    @Cacheable(value = "tx")
    public List<Transaction> getTxByEntityId(@PathVariable("Entity_id") Integer Entity_id){
        List<Transaction> txs =  transactionMapper.getTxByEntityId(Entity_id);
        return txs;
    }

    @GetMapping("/tx/date/{Date}")
    public List<Transaction> getTxByTime(@PathVariable("Date") String date){
        List<Transaction> txs =  transactionMapper.getTxByTime(date);
        return txs;
    }

    @GetMapping("/insert")
    public Transaction insert(Transaction transaction){
        transaction.setTransaction_time(new Date());
        transactionMapper.insertTx(transaction);
        return transaction;
    }

}
