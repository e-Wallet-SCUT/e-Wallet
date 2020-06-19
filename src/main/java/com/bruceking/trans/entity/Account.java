package com.bruceking.trans.entity;

public class Account {

    private Integer account_id;
    private Integer account_customer_id;
    private String account_number;
    private Integer account_type;
    private Float account_balance;
    private String account_password;
    private String account_description;

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getAccount_customer_id() {
        return account_customer_id;
    }

    public void setAccount_customer_id(Integer account_customer_id) {
        this.account_customer_id = account_customer_id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Integer getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Integer account_type) {
        this.account_type = account_type;
    }

    public Float getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Float account_balance) {
        this.account_balance = account_balance;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public String getAccount_description() {
        return account_description;
    }

    public void setAccount_description(String account_description) {
        this.account_description = account_description;
    }
}
