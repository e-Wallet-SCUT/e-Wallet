package com.bruceking.main.settlement.mapper;

import com.bruceking.main.settlement.bean.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface TransactionMapper {

    public List<Transaction> getTxByEntityId(Integer entity_id);

    public List<Transaction> getTxByTime(String date);

    public List<Transaction> getAllTransaction();

    public Transaction checkSign(String transaction_sign);

    public void insertTx(Transaction transaction);

    void updateTransactionAcSign(Integer id, String sign, Date time);
}