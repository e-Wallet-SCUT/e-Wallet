package com.bruceking.clearing.service;

import com.bruceking.clearing.pojo.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> findAllTransaction();
}
