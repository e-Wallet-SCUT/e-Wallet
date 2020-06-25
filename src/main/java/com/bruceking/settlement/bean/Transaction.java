package com.bruceking.settlement.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Integer transaction_id;
    private Integer transaction_from_entity_id;
    private String transaction_from_entity_account;
    private Integer transaction_to_entity_id;
    private String transaction_to_entity_account;
    private BigDecimal transaction_currency_amount;
    private BigDecimal transaction_currency_fee;
    private Integer transaction_currency_id;
    private Date transaction_time;
    private Date transaction_send_time;
    private String transaction_sign;

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", transaction_from_entity_id=" + transaction_from_entity_id +
                ", transaction_from_entity_account='" + transaction_from_entity_account + '\'' +
                ", transaction_to_entity_id=" + transaction_to_entity_id +
                ", transaction_to_entity_account='" + transaction_to_entity_account + '\'' +
                ", transaction_currency_amount=" + transaction_currency_amount +
                ", transaction_currency_fee=" + transaction_currency_fee +
                ", transaction_currency_id=" + transaction_currency_id +
                ", transaction_time=" + transaction_time +
                ", transaction_send_time=" + transaction_send_time +
                ", transaction_sign='" + transaction_sign + '\'' +
                '}';
    }

    public String getSignString() {
        return "Transaction{" +
                "transaction_from_entity_id=" + transaction_from_entity_id +
                ", transaction_from_entity_account='" + transaction_from_entity_account + '\'' +
                ", transaction_to_entity_id=" + transaction_to_entity_id +
                ", transaction_to_entity_account='" + transaction_to_entity_account + '\'' +
                ", transaction_currency_amount=" + transaction_currency_amount +
                ", transaction_currency_id=" + transaction_currency_id +
                ", transaction_send_time=" + transaction_send_time +
                '}';
    }

    public BigDecimal getTransaction_currency_amount() {
        return transaction_currency_amount;
    }

    public void setTransaction_currency_amount(BigDecimal transaction_currency_amount) {
        this.transaction_currency_amount = transaction_currency_amount;
    }

    public BigDecimal getTransaction_currency_fee() {
        return transaction_currency_fee;
    }

    public void setTransaction_currency_fee(BigDecimal transaction_currency_fee) {
        this.transaction_currency_fee = transaction_currency_fee;
    }

    public Date getTransaction_send_time() {
        return transaction_send_time;
    }

    public void setTransaction_send_time(Date transaction_send_time) {
        this.transaction_send_time = transaction_send_time;
    }

    public String getTransaction_sign() {
        return transaction_sign;
    }

    public void setTransaction_sign(String transaction_sign) {
        this.transaction_sign = transaction_sign;
    }

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
