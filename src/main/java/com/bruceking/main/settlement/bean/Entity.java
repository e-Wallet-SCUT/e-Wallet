package com.bruceking.main.settlement.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Entity {
    @Id
    private Integer entity_id;
    private String entity_name;
    private Integer currency_id;
    private BigDecimal currency_amount;
    private BigDecimal currency_yesterday_stm;
    private String public_key;
    private String private_key;
    private Integer user_id;
}
