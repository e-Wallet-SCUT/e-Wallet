package com.bruceking.main.goods.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Transaction {
    private Integer transactionId;

    private Integer transactionEntityLongId;

    private Integer transactionEntityShortId;

    private Integer transactionEntityFeeId;

    private BigDecimal transactionLongAmount;

    private BigDecimal transactionShortAmount;

    private BigDecimal transactionFeeAmount;

    private String transactionType;

    private Date transactionDate;

    private String transactionDescription;

}