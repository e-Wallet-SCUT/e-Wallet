package com.bruceking.main.trans.service;


import com.bruceking.main.trans.entity.Account;
import com.bruceking.main.trans.entity.Transfer;

public interface TransService {

    //查询账户
    Account selectAccount(Integer id, Integer type);
    //插入转账记录
    void insertTransfer(Transfer transfer);
    //插入交易记录
    void insertTransaction(Transfer transfer);
    //更新账户余额
    void updateAccount(Transfer transfer);
}
