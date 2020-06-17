package com.bruceking.clearing.pojo;

import java.math.BigDecimal;
import java.util.Date;

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

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionEntityLongId() {
        return transactionEntityLongId;
    }

    public void setTransactionEntityLongId(Integer transactionEntityLongId) {
        this.transactionEntityLongId = transactionEntityLongId;
    }

    public Integer getTransactionEntityShortId() {
        return transactionEntityShortId;
    }

    public void setTransactionEntityShortId(Integer transactionEntityShortId) {
        this.transactionEntityShortId = transactionEntityShortId;
    }

    public Integer getTransactionEntityFeeId() {
        return transactionEntityFeeId;
    }

    public void setTransactionEntityFeeId(Integer transactionEntityFeeId) {
        this.transactionEntityFeeId = transactionEntityFeeId;
    }

    public BigDecimal getTransactionLongAmount() {
        return transactionLongAmount;
    }

    public void setTransactionLongAmount(BigDecimal transactionLongAmount) {
        this.transactionLongAmount = transactionLongAmount;
    }

    public BigDecimal getTransactionShortAmount() {
        return transactionShortAmount;
    }

    public void setTransactionShortAmount(BigDecimal transactionShortAmount) {
        this.transactionShortAmount = transactionShortAmount;
    }

    public BigDecimal getTransactionFeeAmount() {
        return transactionFeeAmount;
    }

    public void setTransactionFeeAmount(BigDecimal transactionFeeAmount) {
        this.transactionFeeAmount = transactionFeeAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType == null ? null : transactionType.trim();
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription == null ? null : transactionDescription.trim();
    }
}