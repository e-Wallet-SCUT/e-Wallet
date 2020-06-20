package com.bruceking.trans.dao;

import com.bruceking.trans.entity.Account;
import com.bruceking.trans.entity.Transfer;
import org.apache.ibatis.annotations.*;

public interface TransDao {

    //查询账户
    @Select("select * from account where account_customer_id=#{id} and account_type=#{type}")
    Account selectAccount(@Param("id") Integer id, @Param("type") Integer type);

    //插入转账记录
    @Insert("insert into tranfer(transfer_pay_id,transfer_pay_type,transfer_target_type,transfer_target_id,transfer_amount,transfer_date,transfer_description)" +
            " values(#{transfer_pay_id},#{transfer_pay_type},#{transfer_target_type},#{transfer_target_id},#{transfer_amount},NOW(),#{transfer_description})")
    void insertTransfer(Transfer transfer);

    //插入交易记录
    @Insert("insert into transaction(transaction_entity_long_id,transaction_entity_short_id,transaction_long_amount,transaction_short_amount,transaction_type,transaction_date,transaction_description)" +
            " values(#{transfer_target_id},#{transfer_pay_id},#{transfer_amount},#{transfer_amount},\"transfer\",NOW(),#{transfer_description})")
    void insertTransaction(Transfer transfer);

    //更新账户余额
    @Update("update account set account_balance=account_balance-#{transfer_amount}" +
            " where account_customer_id=#{transfer_pay_id} and account_type=#{transfer_pay_type};" +
            " update account set account_balance=account_balance+#{transfer_amount}\n" +
            " where account_customer_id=#{transfer_target_id} and account_type=#{transfer_target_type}")
    void updateAccount(Transfer transfer);
}
