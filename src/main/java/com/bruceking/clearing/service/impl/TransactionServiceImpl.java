package com.bruceking.clearing.service.impl;

import com.bruceking.clearing.mapper.TransactionMapper;
import com.bruceking.clearing.pojo.Transaction;
import com.bruceking.clearing.pojo.TransactionExample;
import com.bruceking.clearing.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    /**
     * 添加一条transaction记录
     * @param transaction
     */
    @Override
    @Transactional
    public void addTransaction(Transaction transaction) {
        this.transactionMapper.insert(transaction);
    }

    /**
     * 返回所有transaction的集合
     */
    @Override
    public List<Transaction> findAllTransaction() {
        TransactionExample transactionExample = new TransactionExample();
        return this.transactionMapper.selectByExample(transactionExample);
    }

    /**
     * 遍历transaction集合，根据参数entityId计算出该金融实体的头寸
     * @param entityId 某金融实体的id，entity表的主键
     * @return 返回该头寸
     */
    @Override
    public BigDecimal countPosition(Integer entityId, Date date) {
        TransactionExample transactionExample = new TransactionExample();
        List<Transaction> allTransaction = this.transactionMapper.selectByExample(transactionExample);
        BigDecimal entityPosition = new BigDecimal("0");
        for (Transaction transaction : allTransaction) {
            if (transaction.getTransactionDate().getYear() == date.getYear() &&
                    transaction.getTransactionDate().getMonth() == date.getMonth() &&
                    transaction.getTransactionDate().getDay() == date.getDay()) {
                if (transaction.getTransactionEntityLongId() == entityId) {
                    entityPosition = entityPosition.add(transaction.getTransactionLongAmount());
                }
                if (transaction.getTransactionEntityShortId() == entityId) {
                    entityPosition = entityPosition.subtract(transaction.getTransactionShortAmount());
                }
                if (transaction.getTransactionEntityFeeId() == entityId) {
                    entityPosition = entityPosition.subtract(transaction.getTransactionFeeAmount());
                }
            }
        }
        return entityPosition;
    }

}
