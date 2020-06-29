package com.bruceking.bill.mapper;


import com.bruceking.bill.bean.Account;
import com.bruceking.bill.bean.transfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

@Mapper
public interface transferMapper {
    @Select("select * from account where account_customer_id=#{id}")
    Collection<Account> selectAccount(@Param("id") Integer id);

    @Select("select * from tranfer where transfer_pay_id=#{transfer_pay_id}")
    Collection<transfer> selectTransfer(@Param("transfer_pay_id") Integer transfer_pay_id);
}
