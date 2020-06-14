package com.bruceking.trans.entity;

import java.util.Date;

public class Tranfer {

    private Integer transfer_id;
    private Integer transfer_account_id;
    private String transfer_target_bank;
    private String transfer_target_id;
    private Float transfer_amount;
    private Date transfer_date;
    private String transfer_description;

    public Integer getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(Integer transfer_id) {
        this.transfer_id = transfer_id;
    }

    public Integer getTransfer_account_id() {
        return transfer_account_id;
    }

    public void setTransfer_account_id(Integer transfer_account_id) {
        this.transfer_account_id = transfer_account_id;
    }

    public String getTransfer_target_bank() {
        return transfer_target_bank;
    }

    public void setTransfer_target_bank(String transfer_target_bank) {
        this.transfer_target_bank = transfer_target_bank;
    }

    public String getTransfer_target_id() {
        return transfer_target_id;
    }

    public void setTransfer_target_id(String transfer_target_id) {
        this.transfer_target_id = transfer_target_id;
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
