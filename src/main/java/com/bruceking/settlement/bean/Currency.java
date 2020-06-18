package com.bruceking.settlement.bean;

public class Currency {

    private Integer currency_id;
    private String currency_type;
    private Double currency_er;

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

    public Double getCurrency_er() {
        return currency_er;
    }

    public void setCurrency_er(Double currency_er) {
        this.currency_er = currency_er;
    }
}
