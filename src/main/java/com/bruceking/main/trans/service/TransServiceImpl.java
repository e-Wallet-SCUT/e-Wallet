package com.bruceking.main.trans.service;

import com.bruceking.main.trans.dao.TransDao;
import com.bruceking.main.trans.entity.Account;
import com.bruceking.main.trans.entity.Transfer;
import com.bruceking.main.trans.entity.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransServiceImpl implements TransService {

    @Autowired(required = false)
    private TransDao transDao;

    //查询账户
    @Override
    public Account selectAccount(Integer id, Integer type) {
        return transDao.selectAccount(id,type);
    }

    //插入转账记录
    @Override
    public void insertTransfer(Transfer transfer) {
        transDao.insertTransfer(transfer);
    }

    //插入交易记录
    @Override
    public void insertTransaction(Transfer transfer) {
        transDao.insertTransaction(transfer);
    }

    //更新账户余额
    @Override
    public void updateAccount(Transfer transfer) {
        transDao.updateAccount(transfer);
    }

    @Override
    public void updateAccountw(Withdraw withdraw) {
        transDao.updateAccountw(withdraw);
    }

    @Override
    public void updateIncome(Withdraw withdraw) {
        transDao.updateIncome(withdraw);
    }

    @Override
    public void insertWithdraw(Withdraw withdraw) {
        transDao.insertWithdraw(withdraw);
    }
}
