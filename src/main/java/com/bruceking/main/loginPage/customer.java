package com.bruceking.main.loginPage;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//customer的一个实体类

public class customer {
    private int customer_id;
    private String customer_name;
    private String customer_mobile;
    private String customer_email;
    private String customer_username;
    private String customer_password;
    private String customer_address;
    private int customer_age;
    private String customer_sex;
    private Date customer_date;



    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_mobile() {
        return customer_mobile;
    }

    public void setCustomer_mobile(String customer_mobile) {
        this.customer_mobile = customer_mobile;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public int getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(int customer_age) {
        this.customer_age = customer_age;
    }

    public String getCustomer_sex() {
        return customer_sex;
    }

    public void setCustomer_sex(String customer_sex) {
        this.customer_sex = customer_sex;
    }

    public String getCustomer_date() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(customer_date);
    }

    public void setCustomer_date(Date customer_date) {
        this.customer_date = customer_date;
    }
    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public String getCustomer_name() {
        return customer_name;
    }
}
