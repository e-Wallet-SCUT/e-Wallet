package com.bruceking.trans.mapper;


import com.bruceking.trans.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    void insertAccount(Account account);
}
