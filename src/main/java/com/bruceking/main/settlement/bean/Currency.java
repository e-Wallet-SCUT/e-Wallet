package com.bruceking.main.settlement.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Currency {
    @Id
    private Integer currency_id;
    private String currency_type;
    private BigDecimal currency_er;

}
