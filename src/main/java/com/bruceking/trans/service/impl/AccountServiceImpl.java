package com.bruceking.trans.service.impl;

import com.bruceking.trans.entity.Account;
import com.bruceking.trans.mapper.AccountMapper;
import com.bruceking.trans.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void addAccount(Account account) {
        this.accountMapper.insertAccount(account);
    }
}
