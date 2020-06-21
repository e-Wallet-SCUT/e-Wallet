package com.e_wallet.springboot.bean;

import java.io.Serializable;
import java.util.Date;

public class transfer implements Serializable {
    private Integer transfer_id;
    private Integer transfer_pay_id;
    private String transfer_pay_type;
    private Integer transfer_target_id;
    private String transfer_target_type;
    private Float transfer_amount;
    private Date transfer_date;
    private String transfer_description;

    public Integer getTransfer_id() {
        return transfer_id;
    }

    public Integer getTransfer_pay_id() {
        return transfer_pay_id;
    }

    public void setTransfer_pay_id(Integer transfer_pay_id) {
        this.transfer_pay_id = transfer_pay_id;
    }

    public String getTransfer_pay_type() {
        return transfer_pay_type;
    }

    public void setTransfer_pay_type(String transfer_pay_type) {
        this.transfer_pay_type = transfer_pay_type;
    }

    public Integer getTransfer_target_id() {
        return transfer_target_id;
    }

    public void setTransfer_target_id(Integer transfer_target_id) {
        this.transfer_target_id = transfer_target_id;
    }

    public String getTransfer_target_type() {
        return transfer_target_type;
    }

    public void setTransfer_target_type(String transfer_target_type) {
        this.transfer_target_type = transfer_target_type;
    }

    public Float getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(Float transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public Date getTransfer_date() {
        return transfer_date;
    }

    public void setTransfer_date(Date transfer_date) {
        this.transfer_date = transfer_date;
    }

    public String getTransfer_description() {
        return transfer_description;
    }

    public void setTransfer_description(String transfer_description) {
        this.transfer_description = transfer_description;
    }
}