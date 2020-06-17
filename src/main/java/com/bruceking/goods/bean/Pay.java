package com.bruceking.goods.bean;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Pay implements Serializable {

    private String pay_account_id;
    private String pay_target_id;
    private String pay_type;
    private String pay_name;
    private float pay_amount;
    private Date pay_date;
    private String pay_description;
}
