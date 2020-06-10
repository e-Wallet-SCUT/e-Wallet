package com.bruceking.main.loginPage;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface customerDao {
    @Select("SELECT * FROM customer where customer_username=#{s}")
    public customer getUserByUsername(String s);
}
