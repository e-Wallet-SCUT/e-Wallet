package com.bruceking.main.userInfo;


import com.bruceking.main.loginPage.customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;

@Mapper

public interface userInfoDao {


    @Select("select * from customer where customer_username=#{s}")
    public customer getUserInfoByUsername(String s);


    @Update("update customer set " +
            "customer_mobile=#{mobile}," +
            "customer_email=#{email},customer_address=#{address}" +
            " where customer_username=#{username}")
    public void updateUserInfo(String username,
                               String mobile,
                               String email,
                               String address);

}
