package com.quoll.model;

import java.util.ArrayList;
import java.util.List;

public class OrderitemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OrderitemsExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andGarmentidIsNull() {
            addCriterion("garmentid is null");
            return (Criteria) this;
        }

        public Criteria andGarmentidIsNotNull() {
            addCriterion("garmentid is not null");
            return (Criteria) this;
        }

        public Criteria andGarmentidEqualTo(Integer value) {
            addCriterion("garmentid =", value, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidNotEqualTo(Integer value) {
            addCriterion("garmentid <>", value, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidGreaterThan(Integer value) {
            addCriterion("garmentid >", value, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("garmentid >=", value, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidLessThan(Integer value) {
            addCriterion("garmentid <", value, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidLessThanOrEqualTo(Integer value) {
            addCriterion("garmentid <=", value, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidIn(List<Integer> values) {
            addCriterion("garmentid in", values, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidNotIn(List<Integer> values) {
            addCriterion("garmentid not in", values, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidBetween(Integer value1, Integer value2) {
            addCriterion("garmentid between", value1, value2, "garmentid");
            return (Criteria) this;
        }

        public Criteria andGarmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("garmentid not between", value1, value2, "garmentid");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andPickupnumberIsNull() {
            addCriterion("pickupnumber is null");
            return (Criteria) this;
        }

        public Criteria andPickupnumberIsNotNull() {
            addCriterion("pickupnumber is not null");
            return (Criteria) this;
        }

        public Criteria andPickupnumberEqualTo(Integer value) {
            addCriterion("pickupnumber =", value, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberNotEqualTo(Integer value) {
            addCriterion("pickupnumber <>", value, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberGreaterThan(Integer value) {
            addCriterion("pickupnumber >", value, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pickupnumber >=", value, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberLessThan(Integer value) {
            addCriterion("pickupnumber <", value, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberLessThanOrEqualTo(Integer value) {
            addCriterion("pickupnumber <=", value, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberIn(List<Integer> values) {
            addCriterion("pickupnumber in", values, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberNotIn(List<Integer> values) {
            addCriterion("pickupnumber not in", values, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberBetween(Integer value1, Integer value2) {
            addCriterion("pickupnumber between", value1, value2, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPickupnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pickupnumber not between", value1, value2, "pickupnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberIsNull() {
            addCriterion("packnumber is null");
            return (Criteria) this;
        }

        public Criteria andPacknumberIsNotNull() {
            addCriterion("packnumber is not null");
            return (Criteria) this;
        }

        public Criteria andPacknumberEqualTo(Integer value) {
            addCriterion("packnumber =", value, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberNotEqualTo(Integer value) {
            addCriterion("packnumber <>", value, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberGreaterThan(Integer value) {
            addCriterion("packnumber >", value, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("packnumber >=", value, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberLessThan(Integer value) {
            addCriterion("packnumber <", value, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberLessThanOrEqualTo(Integer value) {
            addCriterion("packnumber <=", value, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberIn(List<Integer> values) {
            addCriterion("packnumber in", values, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberNotIn(List<Integer> values) {
            addCriterion("packnumber not in", values, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberBetween(Integer value1, Integer value2) {
            addCriterion("packnumber between", value1, value2, "packnumber");
            return (Criteria) this;
        }

        public Criteria andPacknumberNotBetween(Integer value1, Integer value2) {
            addCriterion("packnumber not between", value1, value2, "packnumber");
            return (Criteria) this;
        }
    }

    /**
     */
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