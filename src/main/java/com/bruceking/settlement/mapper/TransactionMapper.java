package com.bruceking.settlement.mapper;

import com.bruceking.settlement.bean.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {

    public List<Transaction> getTxByEntityId(Integer entity_id);

    public List<Transaction> getTxByTime(String date);

    public void insertTx(Transaction transaction);
}
