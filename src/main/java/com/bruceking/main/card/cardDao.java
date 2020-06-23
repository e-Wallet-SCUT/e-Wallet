package com.bruceking.main.card;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface cardDao {

    @Select("select account_password from account where account_customer_id=#{id} limit 1")
    String getAccountPwdByCustomerID(int id);

    @Select("select account_number from account where account_customer_id=#{id}")
    List<String> getAccount_numberByCustomerID(int id);

    @Insert("insert into account (account_number," +
            "account_customer_id,account_type,account_balance," +
            "account_password,account_description) " +
            "values (#{account_number},#{id},#{account_type},#{account_balance},#{account_password},'no')")
    void addAccount_numberByCustomerID(String account_number,int id,int account_type,float account_balance,String account_password);

    @Select("select account_number from card where customer_name=#{name}")
    List<String> getAccount_numberByCustomerName(String name);

    @Select("select type from card where account_number=#{account_number}")
    int getCardType(String account_number);

    @Select("select balance from card where account_number=#{account_number}")
    float getCardBalance(String account_number);

    @Select("select customer_id from customer where customer_name=#{customer_name}")
    int getIDByCustomer_name(String customer_name);
}
