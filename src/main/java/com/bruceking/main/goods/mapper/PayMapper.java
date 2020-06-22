package com.bruceking.main.goods.mapper;

import com.bruceking.main.goods.bean.Pay;
import com.bruceking.main.goods.bean.Transaction;
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
            " values(#{transactionEntityLongId},\"3\",#{transactionLongAmount},#{transactionShortAmount},\"pay\",NOW(),#{transactionDescription})")
    void insertTransaction(Transaction transaction);


    @Select("select account_type from account where account_id=#{primaryID}")
    int selectTransaction(int PrimaryID);
}
