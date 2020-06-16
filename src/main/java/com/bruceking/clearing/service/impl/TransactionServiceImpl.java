package com.bruceking.clearing.service.impl;

import com.bruceking.clearing.mapper.TransactionMapper;
import com.bruceking.clearing.pojo.Transaction;
import com.bruceking.clearing.pojo.TransactionExample;
import com.bruceking.clearing.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    @Transactional
    public void addTransaction(Transaction transaction) {
        this.transactionMapper.insert(transaction);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        TransactionExample transactionExample = new TransactionExample();
        return this.transactionMapper.selectByExample(transactionExample);
    }
}
