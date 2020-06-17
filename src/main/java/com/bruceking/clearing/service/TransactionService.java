package com.bruceking.clearing.service;

import com.bruceking.clearing.pojo.Transaction;

import java.math.BigDecimal;
import java.util.List;


public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> findAllTransaction();
    BigDecimal countPosition(Integer entityId);
}
