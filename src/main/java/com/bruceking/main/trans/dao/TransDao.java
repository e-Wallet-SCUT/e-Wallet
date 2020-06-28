package com.bruceking.main.trans.dao;

import com.bruceking.main.trans.entity.Account;
import com.bruceking.main.trans.entity.Transfer;
import com.bruceking.main.trans.entity.Withdraw;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TransDao {

    //查询账户
    @Select("select * from account where account_customer_id=#{id} and account_type=#{type}")
    Account selectAccount(@Param("id") Integer id, @Param("type") Integer type);

    //插入转账记录
    @Insert("insert into tranfer(transfer_pay_id,transfer_pay_account_id,transfer_target_account_id,transfer_target_id,transfer_amount,transfer_date,transfer_description)" +
            " values(#{transfer_pay_id},#{transfer_pay_account_id},#{transfer_target_account_id},#{transfer_target_id},#{transfer_amount},NOW(),#{transfer_description})")
    void insertTransfer(Transfer transfer);

    //插入交易记录
    @Insert("insert into transaction(transaction_entity_long_id,transaction_entity_short_id,transaction_long_amount,transaction_short_amount,transaction_type,transaction_date,transaction_description)" +
            " values(#{transfer_target_id},#{transfer_pay_id},#{transfer_amount},#{transfer_amount},'transfer',NOW(),#{transfer_description})")
    void insertTransaction(Transfer transfer);

    //更新转账后账户余额
    @Update("update account set account_balance=account_balance-#{transfer_amount}" +
            " where account_id=#{transfer_pay_account_id};"+
            " update account set account_balance=account_balance+#{transfer_amount}" +
            " where account_id=#{transfer_target_account_id}")
    void updateAccount(Transfer transfer);

    //更新提现后账户余额
    @Update("update account set account_balance=account_balance-#{amount}" +
            " where account_customer_id=#{id} and account_type=3;" +
            " update account set account_balance=account_balance+(#{amount}*0.999)" +
            " where account_customer_id=#{id} and account_type=#{type}")
    void updateAccountw(Withdraw withdraw);

    //手续费转入收益账户
    @Update("update entity set entity_balance=entity_balance+(#{amount}*0.001)" +
            " where entity_name='Income'")
    void updateIncome(Withdraw withdraw);

    //插入提现记录
    @Insert("insert into transaction(transaction_entity_long_id,transaction_entity_short_id,transaction_long_amount,transaction_short_amount,transaction_type,transaction_date)" +
            " values(#{type},3,#{amount},#{amount},'withdraw',NOW())")
    void insertWithdraw(Withdraw withdraw);
}
