package com.quoll.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LaundryorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LaundryorderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateddateIsNull() {
            addCriterion("createddate is null");
            return (Criteria) this;
        }

        public Criteria andCreateddateIsNotNull() {
            addCriterion("createddate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateddateEqualTo(Date value) {
            addCriterionForJDBCDate("createddate =", value, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("createddate <>", value, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateGreaterThan(Date value) {
            addCriterionForJDBCDate("createddate >", value, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createddate >=", value, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateLessThan(Date value) {
            addCriterionForJDBCDate("createddate <", value, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createddate <=", value, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateIn(List<Date> values) {
            addCriterionForJDBCDate("createddate in", values, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("createddate not in", values, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createddate between", value1, value2, "createddate");
            return (Criteria) this;
        }

        public Criteria andCreateddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createddate not between", value1, value2, "createddate");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyid =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyid <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyid >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyid >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyid <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyid <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyid in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyid not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyid between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyid not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateIsNull() {
            addCriterion("presetpickupdate is null");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateIsNotNull() {
            addCriterion("presetpickupdate is not null");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateEqualTo(Date value) {
            addCriterionForJDBCDate("presetpickupdate =", value, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("presetpickupdate <>", value, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateGreaterThan(Date value) {
            addCriterionForJDBCDate("presetpickupdate >", value, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("presetpickupdate >=", value, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateLessThan(Date value) {
            addCriterionForJDBCDate("presetpickupdate <", value, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("presetpickupdate <=", value, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateIn(List<Date> values) {
            addCriterionForJDBCDate("presetpickupdate in", values, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("presetpickupdate not in", values, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("presetpickupdate between", value1, value2, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andPresetpickupdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("presetpickupdate not between", value1, value2, "presetpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateIsNull() {
            addCriterion("realpickupdate is null");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateIsNotNull() {
            addCriterion("realpickupdate is not null");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateEqualTo(Date value) {
            addCriterionForJDBCDate("realpickupdate =", value, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("realpickupdate <>", value, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateGreaterThan(Date value) {
            addCriterionForJDBCDate("realpickupdate >", value, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realpickupdate >=", value, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateLessThan(Date value) {
            addCriterionForJDBCDate("realpickupdate <", value, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realpickupdate <=", value, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateIn(List<Date> values) {
            addCriterionForJDBCDate("realpickupdate in", values, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("realpickupdate not in", values, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realpickupdate between", value1, value2, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andRealpickupdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realpickupdate not between", value1, value2, "realpickupdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateIsNull() {
            addCriterion("packingdate is null");
            return (Criteria) this;
        }

        public Criteria andPackingdateIsNotNull() {
            addCriterion("packingdate is not null");
            return (Criteria) this;
        }

        public Criteria andPackingdateEqualTo(Date value) {
            addCriterionForJDBCDate("packingdate =", value, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("packingdate <>", value, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateGreaterThan(Date value) {
            addCriterionForJDBCDate("packingdate >", value, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("packingdate >=", value, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateLessThan(Date value) {
            addCriterionForJDBCDate("packingdate <", value, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("packingdate <=", value, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateIn(List<Date> values) {
            addCriterionForJDBCDate("packingdate in", values, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("packingdate not in", values, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("packingdate between", value1, value2, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPackingdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("packingdate not between", value1, value2, "packingdate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateIsNull() {
            addCriterion("presetdeliverydate is null");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateIsNotNull() {
            addCriterion("presetdeliverydate is not null");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateEqualTo(Date value) {
            addCriterionForJDBCDate("presetdeliverydate =", value, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("presetdeliverydate <>", value, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateGreaterThan(Date value) {
            addCriterionForJDBCDate("presetdeliverydate >", value, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("presetdeliverydate >=", value, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateLessThan(Date value) {
            addCriterionForJDBCDate("presetdeliverydate <", value, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("presetdeliverydate <=", value, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateIn(List<Date> values) {
            addCriterionForJDBCDate("presetdeliverydate in", values, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("presetdeliverydate not in", values, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("presetdeliverydate between", value1, value2, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andPresetdeliverydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("presetdeliverydate not between", value1, value2, "presetdeliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateIsNull() {
            addCriterion("deliverydate is null");
            return (Criteria) this;
        }

        public Criteria andDeliverydateIsNotNull() {
            addCriterion("deliverydate is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverydateEqualTo(Date value) {
            addCriterionForJDBCDate("deliverydate =", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("deliverydate <>", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateGreaterThan(Date value) {
            addCriterionForJDBCDate("deliverydate >", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deliverydate >=", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateLessThan(Date value) {
            addCriterionForJDBCDate("deliverydate <", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deliverydate <=", value, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateIn(List<Date> values) {
            addCriterionForJDBCDate("deliverydate in", values, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("deliverydate not in", values, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deliverydate between", value1, value2, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andDeliverydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deliverydate not between", value1, value2, "deliverydate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDriveridIsNull() {
            addCriterion("driverid is null");
            return (Criteria) this;
        }

        public Criteria andDriveridIsNotNull() {
            addCriterion("driverid is not null");
            return (Criteria) this;
        }

        public Criteria andDriveridEqualTo(Integer value) {
            addCriterion("driverid =", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridNotEqualTo(Integer value) {
            addCriterion("driverid <>", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridGreaterThan(Integer value) {
            addCriterion("driverid >", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("driverid >=", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridLessThan(Integer value) {
            addCriterion("driverid <", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridLessThanOrEqualTo(Integer value) {
            addCriterion("driverid <=", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridIn(List<Integer> values) {
            addCriterion("driverid in", values, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridNotIn(List<Integer> values) {
            addCriterion("driverid not in", values, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridBetween(Integer value1, Integer value2) {
            addCriterion("driverid between", value1, value2, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridNotBetween(Integer value1, Integer value2) {
            addCriterion("driverid not between", value1, value2, "driverid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidIsNull() {
            addCriterion("packingpersonid is null");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidIsNotNull() {
            addCriterion("packingpersonid is not null");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidEqualTo(Integer value) {
            addCriterion("packingpersonid =", value, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidNotEqualTo(Integer value) {
            addCriterion("packingpersonid <>", value, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidGreaterThan(Integer value) {
            addCriterion("packingpersonid >", value, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("packingpersonid >=", value, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidLessThan(Integer value) {
            addCriterion("packingpersonid <", value, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidLessThanOrEqualTo(Integer value) {
            addCriterion("packingpersonid <=", value, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidIn(List<Integer> values) {
            addCriterion("packingpersonid in", values, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidNotIn(List<Integer> values) {
            addCriterion("packingpersonid not in", values, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidBetween(Integer value1, Integer value2) {
            addCriterion("packingpersonid between", value1, value2, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andPackingpersonidNotBetween(Integer value1, Integer value2) {
            addCriterion("packingpersonid not between", value1, value2, "packingpersonid");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andStatushistoryIsNull() {
            addCriterion("statushistory is null");
            return (Criteria) this;
        }

        public Criteria andStatushistoryIsNotNull() {
            addCriterion("statushistory is not null");
            return (Criteria) this;
        }

        public Criteria andStatushistoryEqualTo(String value) {
            addCriterion("statushistory =", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryNotEqualTo(String value) {
            addCriterion("statushistory <>", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryGreaterThan(String value) {
            addCriterion("statushistory >", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryGreaterThanOrEqualTo(String value) {
            addCriterion("statushistory >=", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryLessThan(String value) {
            addCriterion("statushistory <", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryLessThanOrEqualTo(String value) {
            addCriterion("statushistory <=", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryLike(String value) {
            addCriterion("statushistory like", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryNotLike(String value) {
            addCriterion("statushistory not like", value, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryIn(List<String> values) {
            addCriterion("statushistory in", values, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryNotIn(List<String> values) {
            addCriterion("statushistory not in", values, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryBetween(String value1, String value2) {
            addCriterion("statushistory between", value1, value2, "statushistory");
            return (Criteria) this;
        }

        public Criteria andStatushistoryNotBetween(String value1, String value2) {
            addCriterion("statushistory not between", value1, value2, "statushistory");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridIsNull() {
            addCriterion("deliverydriverid is null");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridIsNotNull() {
            addCriterion("deliverydriverid is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridEqualTo(Integer value) {
            addCriterion("deliverydriverid =", value, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridNotEqualTo(Integer value) {
            addCriterion("deliverydriverid <>", value, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridGreaterThan(Integer value) {
            addCriterion("deliverydriverid >", value, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("deliverydriverid >=", value, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridLessThan(Integer value) {
            addCriterion("deliverydriverid <", value, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridLessThanOrEqualTo(Integer value) {
            addCriterion("deliverydriverid <=", value, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridIn(List<Integer> values) {
            addCriterion("deliverydriverid in", values, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridNotIn(List<Integer> values) {
            addCriterion("deliverydriverid not in", values, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridBetween(Integer value1, Integer value2) {
            addCriterion("deliverydriverid between", value1, value2, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andDeliverydriveridNotBetween(Integer value1, Integer value2) {
            addCriterion("deliverydriverid not between", value1, value2, "deliverydriverid");
            return (Criteria) this;
        }

        public Criteria andRecurringflagIsNull() {
            addCriterion("recurringFlag is null");
            return (Criteria) this;
        }

        public Criteria andRecurringflagIsNotNull() {
            addCriterion("recurringFlag is not null");
            return (Criteria) this;
        }

        public Criteria andRecurringflagEqualTo(Integer value) {
            addCriterion("recurringFlag =", value, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagNotEqualTo(Integer value) {
            addCriterion("recurringFlag <>", value, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagGreaterThan(Integer value) {
            addCriterion("recurringFlag >", value, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("recurringFlag >=", value, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagLessThan(Integer value) {
            addCriterion("recurringFlag <", value, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagLessThanOrEqualTo(Integer value) {
            addCriterion("recurringFlag <=", value, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagIn(List<Integer> values) {
            addCriterion("recurringFlag in", values, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagNotIn(List<Integer> values) {
            addCriterion("recurringFlag not in", values, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagBetween(Integer value1, Integer value2) {
            addCriterion("recurringFlag between", value1, value2, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andRecurringflagNotBetween(Integer value1, Integer value2) {
            addCriterion("recurringFlag not between", value1, value2, "recurringflag");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(String value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(String value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(String value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(String value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(String value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(String value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLike(String value) {
            addCriterion("active like", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotLike(String value) {
            addCriterion("active not like", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<String> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<String> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(String value1, String value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(String value1, String value2) {
            addCriterion("active not between", value1, value2, "active");
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