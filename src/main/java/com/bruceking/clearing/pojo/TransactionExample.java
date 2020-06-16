package com.bruceking.clearing.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(Integer value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(Integer value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(Integer value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(Integer value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<Integer> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<Integer> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(Integer value1, Integer value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdIsNull() {
            addCriterion("transaction_entity_long_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdIsNotNull() {
            addCriterion("transaction_entity_long_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdEqualTo(Integer value) {
            addCriterion("transaction_entity_long_id =", value, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdNotEqualTo(Integer value) {
            addCriterion("transaction_entity_long_id <>", value, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdGreaterThan(Integer value) {
            addCriterion("transaction_entity_long_id >", value, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_entity_long_id >=", value, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdLessThan(Integer value) {
            addCriterion("transaction_entity_long_id <", value, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_entity_long_id <=", value, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdIn(List<Integer> values) {
            addCriterion("transaction_entity_long_id in", values, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdNotIn(List<Integer> values) {
            addCriterion("transaction_entity_long_id not in", values, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdBetween(Integer value1, Integer value2) {
            addCriterion("transaction_entity_long_id between", value1, value2, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityLongIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_entity_long_id not between", value1, value2, "transactionEntityLongId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdIsNull() {
            addCriterion("transaction_entity_short_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdIsNotNull() {
            addCriterion("transaction_entity_short_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdEqualTo(Integer value) {
            addCriterion("transaction_entity_short_id =", value, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdNotEqualTo(Integer value) {
            addCriterion("transaction_entity_short_id <>", value, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdGreaterThan(Integer value) {
            addCriterion("transaction_entity_short_id >", value, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_entity_short_id >=", value, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdLessThan(Integer value) {
            addCriterion("transaction_entity_short_id <", value, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_entity_short_id <=", value, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdIn(List<Integer> values) {
            addCriterion("transaction_entity_short_id in", values, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdNotIn(List<Integer> values) {
            addCriterion("transaction_entity_short_id not in", values, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdBetween(Integer value1, Integer value2) {
            addCriterion("transaction_entity_short_id between", value1, value2, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityShortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_entity_short_id not between", value1, value2, "transactionEntityShortId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdIsNull() {
            addCriterion("transaction_entity_fee_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdIsNotNull() {
            addCriterion("transaction_entity_fee_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdEqualTo(Integer value) {
            addCriterion("transaction_entity_fee_id =", value, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdNotEqualTo(Integer value) {
            addCriterion("transaction_entity_fee_id <>", value, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdGreaterThan(Integer value) {
            addCriterion("transaction_entity_fee_id >", value, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_entity_fee_id >=", value, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdLessThan(Integer value) {
            addCriterion("transaction_entity_fee_id <", value, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_entity_fee_id <=", value, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdIn(List<Integer> values) {
            addCriterion("transaction_entity_fee_id in", values, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdNotIn(List<Integer> values) {
            addCriterion("transaction_entity_fee_id not in", values, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdBetween(Integer value1, Integer value2) {
            addCriterion("transaction_entity_fee_id between", value1, value2, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionEntityFeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_entity_fee_id not between", value1, value2, "transactionEntityFeeId");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountIsNull() {
            addCriterion("transaction_long_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountIsNotNull() {
            addCriterion("transaction_long_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountEqualTo(BigDecimal value) {
            addCriterion("transaction_long_amount =", value, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountNotEqualTo(BigDecimal value) {
            addCriterion("transaction_long_amount <>", value, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountGreaterThan(BigDecimal value) {
            addCriterion("transaction_long_amount >", value, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_long_amount >=", value, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountLessThan(BigDecimal value) {
            addCriterion("transaction_long_amount <", value, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_long_amount <=", value, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountIn(List<BigDecimal> values) {
            addCriterion("transaction_long_amount in", values, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountNotIn(List<BigDecimal> values) {
            addCriterion("transaction_long_amount not in", values, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_long_amount between", value1, value2, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionLongAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_long_amount not between", value1, value2, "transactionLongAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountIsNull() {
            addCriterion("transaction_short_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountIsNotNull() {
            addCriterion("transaction_short_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountEqualTo(BigDecimal value) {
            addCriterion("transaction_short_amount =", value, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountNotEqualTo(BigDecimal value) {
            addCriterion("transaction_short_amount <>", value, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountGreaterThan(BigDecimal value) {
            addCriterion("transaction_short_amount >", value, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_short_amount >=", value, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountLessThan(BigDecimal value) {
            addCriterion("transaction_short_amount <", value, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_short_amount <=", value, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountIn(List<BigDecimal> values) {
            addCriterion("transaction_short_amount in", values, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountNotIn(List<BigDecimal> values) {
            addCriterion("transaction_short_amount not in", values, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_short_amount between", value1, value2, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionShortAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_short_amount not between", value1, value2, "transactionShortAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountIsNull() {
            addCriterion("transaction_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountIsNotNull() {
            addCriterion("transaction_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountEqualTo(BigDecimal value) {
            addCriterion("transaction_fee_amount =", value, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountNotEqualTo(BigDecimal value) {
            addCriterion("transaction_fee_amount <>", value, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountGreaterThan(BigDecimal value) {
            addCriterion("transaction_fee_amount >", value, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_fee_amount >=", value, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountLessThan(BigDecimal value) {
            addCriterion("transaction_fee_amount <", value, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("transaction_fee_amount <=", value, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountIn(List<BigDecimal> values) {
            addCriterion("transaction_fee_amount in", values, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountNotIn(List<BigDecimal> values) {
            addCriterion("transaction_fee_amount not in", values, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_fee_amount between", value1, value2, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionFeeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transaction_fee_amount not between", value1, value2, "transactionFeeAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIsNull() {
            addCriterion("transaction_type is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIsNotNull() {
            addCriterion("transaction_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeEqualTo(String value) {
            addCriterion("transaction_type =", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotEqualTo(String value) {
            addCriterion("transaction_type <>", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThan(String value) {
            addCriterion("transaction_type >", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_type >=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThan(String value) {
            addCriterion("transaction_type <", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThanOrEqualTo(String value) {
            addCriterion("transaction_type <=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLike(String value) {
            addCriterion("transaction_type like", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotLike(String value) {
            addCriterion("transaction_type not like", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIn(List<String> values) {
            addCriterion("transaction_type in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotIn(List<String> values) {
            addCriterion("transaction_type not in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeBetween(String value1, String value2) {
            addCriterion("transaction_type between", value1, value2, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotBetween(String value1, String value2) {
            addCriterion("transaction_type not between", value1, value2, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIsNull() {
            addCriterion("transaction_date is null");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIsNotNull() {
            addCriterion("transaction_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionDateEqualTo(Date value) {
            addCriterion("transaction_date =", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotEqualTo(Date value) {
            addCriterion("transaction_date <>", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThan(Date value) {
            addCriterion("transaction_date >", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("transaction_date >=", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThan(Date value) {
            addCriterion("transaction_date <", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateLessThanOrEqualTo(Date value) {
            addCriterion("transaction_date <=", value, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateIn(List<Date> values) {
            addCriterion("transaction_date in", values, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotIn(List<Date> values) {
            addCriterion("transaction_date not in", values, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateBetween(Date value1, Date value2) {
            addCriterion("transaction_date between", value1, value2, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDateNotBetween(Date value1, Date value2) {
            addCriterion("transaction_date not between", value1, value2, "transactionDate");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionIsNull() {
            addCriterion("transaction_description is null");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionIsNotNull() {
            addCriterion("transaction_description is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionEqualTo(String value) {
            addCriterion("transaction_description =", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionNotEqualTo(String value) {
            addCriterion("transaction_description <>", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionGreaterThan(String value) {
            addCriterion("transaction_description >", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_description >=", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionLessThan(String value) {
            addCriterion("transaction_description <", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("transaction_description <=", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionLike(String value) {
            addCriterion("transaction_description like", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionNotLike(String value) {
            addCriterion("transaction_description not like", value, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionIn(List<String> values) {
            addCriterion("transaction_description in", values, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionNotIn(List<String> values) {
            addCriterion("transaction_description not in", values, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionBetween(String value1, String value2) {
            addCriterion("transaction_description between", value1, value2, "transactionDescription");
            return (Criteria) this;
        }

        public Criteria andTransactionDescriptionNotBetween(String value1, String value2) {
            addCriterion("transaction_description not between", value1, value2, "transactionDescription");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}