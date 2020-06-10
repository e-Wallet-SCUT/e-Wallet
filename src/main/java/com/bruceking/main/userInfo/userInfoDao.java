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


    @Update("update customer set customer_name=#{name}," +
            "customer_age=#{age},customer_sex=#{sex},customer_mobile=#{mobile}," +
            "customer_email=#{email},customer_address=#{address}" +
            ",customer_date=#{date} where customer_username=#{username}")
    public void updateUserInfo(String username,
                               String name,
                               String age,
                               String sex,
                               String mobile,
                               String email,
                               String address,
                               Date date);

}
