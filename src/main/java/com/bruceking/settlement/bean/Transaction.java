package com.bruceking.settlement.bean;

import java.util.Date;

public class Transaction {
    private Integer transaction_id;
    private Integer transaction_from_entity_id;
    private String transaction_from_entity_account;
    private Integer transaction_to_entity_id;
    private String transaction_to_entity_account;
    private Double transaction_currency_amount;
    private Integer transaction_currency_id;
    private Date transaction_time;

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getTransaction_from_entity_id() {
        return transaction_from_entity_id;
    }

    public void setTransaction_from_entity_id(Integer transaction_from_entity_id) {
        this.transaction_from_entity_id = transaction_from_entity_id;
    }

    public String getTransaction_from_entity_account() {
        return transaction_from_entity_account;
    }

    public void setTransaction_from_entity_account(String transaction_from_entity_account) {
        this.transaction_from_entity_account = transaction_from_entity_account;
    }

    public Integer getTransaction_to_entity_id() {
        return transaction_to_entity_id;
    }

    public void setTransaction_to_entity_id(Integer transaction_to_entity_id) {
        this.transaction_to_entity_id = transaction_to_entity_id;
    }

    public String getTransaction_to_entity_account() {
        return transaction_to_entity_account;
    }

    public void setTransaction_to_entity_account(String transaction_to_entity_account) {
        this.transaction_to_entity_account = transaction_to_entity_account;
    }

    public Double getTransaction_currency_amount() {
        return transaction_currency_amount;
    }

    public void setTransaction_currency_amount(Double transaction_currency_amount) {
        this.transaction_currency_amount = transaction_currency_amount;
    }

    public Integer getTransaction_currency_id() {
        return transaction_currency_id;
    }

    public void setTransaction_currency_id(Integer transaction_currency_id) {
        this.transaction_currency_id = transaction_currency_id;
    }

    public Date getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(Date transaction_time) {
        this.transaction_time = transaction_time;
    }
}
