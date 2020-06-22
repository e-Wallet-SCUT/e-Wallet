package com.bruceking.goods.mapper;

import com.bruceking.clearing.pojo.Transaction;
import com.bruceking.goods.bean.Pay;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PayMapper {

    @Insert("INSERT INTO pay(pay_account_id, pay_target_id, pay_type, pay_amount, pay_date, pay_description) VALUES (" +
            "#{pay_account_id},"+
            "   #{pay_target_id},"+
            "  #{pay_type},"+
            "#{pay_amount},"+
            "#{pay_date},"+
            "#{pay_description})")
    void AddPay(Pay pay);


    //插入交易记录
    @Insert("insert into transaction(transaction_entity_long_id,transaction_entity_short_id,transaction_long_amount,transaction_short_amount,transaction_type,transaction_date,transaction_description)" +
            " values(#{transaction_entity_long_id},\"Prepared\",#{transaction_long_amount},#{transaction_short_amount},\"pay\",NOW(),#{transaction_description})")
    void insertTransaction(Transaction transaction);


    @Select("select account_type from account where account_id=#{primaryID}")
    int selectTransaction(int PrimaryID);
}
