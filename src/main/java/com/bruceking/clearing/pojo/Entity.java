package com.bruceking.clearing.pojo;

import java.math.BigDecimal;

public class Entity {
    private Integer entityId;

    private String entityName;

    private BigDecimal entityBalance;

    private BigDecimal entityDayPosition;

    private String entityDescription;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName == null ? null : entityName.trim();
    }

    public BigDecimal getEntityBalance() {
        return entityBalance;
    }

    public void setEntityBalance(BigDecimal entityBalance) {
        this.entityBalance = entityBalance;
    }

    public BigDecimal getEntityDayPosition() {
        return entityDayPosition;
    }

    public void setEntityDayPosition(BigDecimal entityDayPosition) {
        this.entityDayPosition = entityDayPosition;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public void setEntityDescription(String entityDescription) {
        this.entityDescription = entityDescription == null ? null : entityDescription.trim();
    }
}