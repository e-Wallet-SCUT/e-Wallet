package com.bruceking.main.settlement.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Charge {
    private BigDecimal value;
    private String password;
}
