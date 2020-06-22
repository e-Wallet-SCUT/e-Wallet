package com.bruceking.settlement.bean;

public class Entity {
    private Integer entity_id;
    private String entity_name;
    private Integer currency_id;
    private double currency_amount;
    private String public_key;
    private String private_key;

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getPrivate_key() {
        return private_key;
    }

    public void setPrivate_key(String private_key) {
        this.private_key = private_key;
    }

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
