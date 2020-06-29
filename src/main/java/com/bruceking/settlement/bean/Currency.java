package com.bruceking.settlement.bean;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Currency {
    @Id
    private Integer currency_id;
    private String currency_type;
    private BigDecimal currency_er;

    public Integer getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(Integer currency_id) {
        this.currency_id = currency_id;
    }

    public String getCurrency_type() {
        return currency_type;
    }

    public void setCurrency_type(String currency_type) {
        this.currency_type = currency_type;
    }

    public BigDecimal getCurrency_er() {
        return currency_er;
    }

    public void setCurrency_er(BigDecimal currency_er) {
        this.currency_er = currency_er;
    }
}
