package com.bruceking.clearing.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EntityExample() {
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

        public Criteria andEntityIdIsNull() {
            addCriterion("entity_id is null");
            return (Criteria) this;
        }

        public Criteria andEntityIdIsNotNull() {
            addCriterion("entity_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntityIdEqualTo(Integer value) {
            addCriterion("entity_id =", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotEqualTo(Integer value) {
            addCriterion("entity_id <>", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdGreaterThan(Integer value) {
            addCriterion("entity_id >", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("entity_id >=", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdLessThan(Integer value) {
            addCriterion("entity_id <", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdLessThanOrEqualTo(Integer value) {
            addCriterion("entity_id <=", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdIn(List<Integer> values) {
            addCriterion("entity_id in", values, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotIn(List<Integer> values) {
            addCriterion("entity_id not in", values, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdBetween(Integer value1, Integer value2) {
            addCriterion("entity_id between", value1, value2, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("entity_id not between", value1, value2, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityNameIsNull() {
            addCriterion("entity_name is null");
            return (Criteria) this;
        }

        public Criteria andEntityNameIsNotNull() {
            addCriterion("entity_name is not null");
            return (Criteria) this;
        }

        public Criteria andEntityNameEqualTo(String value) {
            addCriterion("entity_name =", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotEqualTo(String value) {
            addCriterion("entity_name <>", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameGreaterThan(String value) {
            addCriterion("entity_name >", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameGreaterThanOrEqualTo(String value) {
            addCriterion("entity_name >=", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameLessThan(String value) {
            addCriterion("entity_name <", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameLessThanOrEqualTo(String value) {
            addCriterion("entity_name <=", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameLike(String value) {
            addCriterion("entity_name like", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotLike(String value) {
            addCriterion("entity_name not like", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameIn(List<String> values) {
            addCriterion("entity_name in", values, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotIn(List<String> values) {
            addCriterion("entity_name not in", values, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameBetween(String value1, String value2) {
            addCriterion("entity_name between", value1, value2, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotBetween(String value1, String value2) {
            addCriterion("entity_name not between", value1, value2, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceIsNull() {
            addCriterion("entity_balance is null");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceIsNotNull() {
            addCriterion("entity_balance is not null");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceEqualTo(BigDecimal value) {
            addCriterion("entity_balance =", value, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceNotEqualTo(BigDecimal value) {
            addCriterion("entity_balance <>", value, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceGreaterThan(BigDecimal value) {
            addCriterion("entity_balance >", value, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("entity_balance >=", value, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceLessThan(BigDecimal value) {
            addCriterion("entity_balance <", value, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("entity_balance <=", value, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceIn(List<BigDecimal> values) {
            addCriterion("entity_balance in", values, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceNotIn(List<BigDecimal> values) {
            addCriterion("entity_balance not in", values, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("entity_balance between", value1, value2, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("entity_balance not between", value1, value2, "entityBalance");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionIsNull() {
            addCriterion("entity_day_position is null");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionIsNotNull() {
            addCriterion("entity_day_position is not null");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionEqualTo(BigDecimal value) {
            addCriterion("entity_day_position =", value, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionNotEqualTo(BigDecimal value) {
            addCriterion("entity_day_position <>", value, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionGreaterThan(BigDecimal value) {
            addCriterion("entity_day_position >", value, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("entity_day_position >=", value, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionLessThan(BigDecimal value) {
            addCriterion("entity_day_position <", value, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("entity_day_position <=", value, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionIn(List<BigDecimal> values) {
            addCriterion("entity_day_position in", values, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionNotIn(List<BigDecimal> values) {
            addCriterion("entity_day_position not in", values, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("entity_day_position between", value1, value2, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDayPositionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("entity_day_position not between", value1, value2, "entityDayPosition");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionIsNull() {
            addCriterion("entity_description is null");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionIsNotNull() {
            addCriterion("entity_description is not null");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionEqualTo(String value) {
            addCriterion("entity_description =", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionNotEqualTo(String value) {
            addCriterion("entity_description <>", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionGreaterThan(String value) {
            addCriterion("entity_description >", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("entity_description >=", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionLessThan(String value) {
            addCriterion("entity_description <", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionLessThanOrEqualTo(String value) {
            addCriterion("entity_description <=", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionLike(String value) {
            addCriterion("entity_description like", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionNotLike(String value) {
            addCriterion("entity_description not like", value, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionIn(List<String> values) {
            addCriterion("entity_description in", values, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionNotIn(List<String> values) {
            addCriterion("entity_description not in", values, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionBetween(String value1, String value2) {
            addCriterion("entity_description between", value1, value2, "entityDescription");
            return (Criteria) this;
        }

        public Criteria andEntityDescriptionNotBetween(String value1, String value2) {
            addCriterion("entity_description not between", value1, value2, "entityDescription");
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