package com.bruceking.main.trans.service;


import com.bruceking.main.trans.entity.Account;
import com.bruceking.main.trans.entity.Transfer;
import com.bruceking.main.trans.entity.Withdraw;

public interface TransService {

    //查询账户
    Account selectAccount(Integer id, Integer type);
    //插入转账记录
    void insertTransfer(Transfer transfer);
    //插入交易记录
    void insertTransaction(Transfer transfer);
    //更新转账后账户余额
    void updateAccount(Transfer transfer);
    //更新体现后账户余额
    void updateAccountw(Withdraw withdraw);
    //手续费转入收益账户
    void updateIncome(Withdraw withdraw);
    //插入提现记录
    void insertWithdraw(Withdraw withdraw);
}
