package com.bruceking.main.goods.mapper;

import com.bruceking.main.goods.bean.Pay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
}
