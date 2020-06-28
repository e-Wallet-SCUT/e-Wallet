package com.bruceking.main.goods.bean;


import lombok.Data;

@Data
public class Account {

    private Integer account_id;
    private Integer account_customer_id;
    private String account_number;
    private Integer account_type;
    private Float account_balance;
    private String account_password;
    private String account_description;


}
