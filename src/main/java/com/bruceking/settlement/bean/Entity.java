package com.bruceking.settlement.bean;

public class Entity {
    private Integer entity_id;
    private String entity_name;
    private Integer currency_id;
    private double currency_amount;

    public double getCurrency_yesterday_stm() {
        return currency_yesterday_stm;
    }

    public void setCurrency_yesterday_stm(double currency_yesterday_stm) {
        this.currency_yesterday_stm = currency_yesterday_stm;
    }

    private double currency_yesterday_stm;

    public Integer getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Integer entity_id) {
        this.entity_id = entity_id;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public Integer getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(Integer currency_id) {
        this.currency_id = currency_id;
    }

    public double getCurrency_amount() {
        return currency_amount;
    }

    public void setCurrency_amount(double currency_amount) {
        this.currency_amount = currency_amount;
    }
}
