package com.e_wallet.springboot.bean;

public class TurnOver {
    private String account_type;
    private Double y;

    public Double getY() {
        return y;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
}
