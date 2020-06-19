package com.bruceking.trans.dao;

import com.bruceking.trans.entity.Account;
import com.bruceking.trans.entity.Transfer;
import org.apache.ibatis.annotations.Param;

public interface TransDao {

    //查询账户
    Account selectAccount(@Param("id") Integer id, @Param("type") Integer type);
    //插入转账记录
    void insertTransfer(Transfer transfer);
    //插入交易记录
    void insertTransaction(Transfer transfer);
    //更新账户余额
    void updateAccount(Transfer transfer);
}
