package com.bruceking.main.bill.mapper;


import com.bruceking.main.bill.bean.Account;
import com.bruceking.main.bill.bean.transfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.Date;

@Mapper
public interface BillMapper {
    @Select("select * from account where account_customer_id=#{id}")
    Collection<Account> selectAccount(@Param("id") Integer id);

    @Select("select * from tranfer where transfer_pay_id=#{transfer_pay_id}")
    Collection<transfer> selectTransfer(@Param("transfer_pay_id") Integer transfer_pay_id);

    @Select("select * from tranfer where transfer_pay_id=#{transfer_pay_id} and transfer_date>=#{transfer_Bdate}")
    Collection<transfer> selectTransferByBDate(@Param("transfer_pay_id") Integer transfer_pay_id, @Param("transfer_Bdate") Date transfer_Bdate);

    @Select("select * from tranfer where transfer_pay_id=#{transfer_pay_id} and transfer_date<=#{transfer_Edate}")
    Collection<transfer> selectTransferByEDate(@Param("transfer_pay_id") Integer transfer_pay_id, @Param("transfer_Edate") Date transfer_Edate);

    @Select("select * from tranfer where transfer_pay_id=#{transfer_pay_id} and transfer_date>=#{transfer_Bdate} and transfer_date<=#{transfer_Edate}")
    Collection<transfer> selectTransferByBDateAndEDate(@Param("transfer_pay_id") Integer transfer_pay_id, @Param("transfer_Bdate") Date transfer_Bdate, @Param("transfer_Edate") Date transfer_Edate);

}
