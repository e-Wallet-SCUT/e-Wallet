package com.bruceking.trans.service;


import com.bruceking.trans.entity.Account;
import com.bruceking.trans.entity.Transfer;

public interface TransService {

    //查询账户
    Account selectAccount(Integer id, String type);
    //插入转账记录
    void insertTrans(Transfer transfer);
    //更新账户余额
    void updateAccount(Transfer transfer);
}
