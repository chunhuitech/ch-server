package cn.chunhuitech.www.core.admin.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProductActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductActivityExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andClientFlagIsNull() {
            addCriterion("client_flag is null");
            return (Criteria) this;
        }

        public Criteria andClientFlagIsNotNull() {
            addCriterion("client_flag is not null");
            return (Criteria) this;
        }

        public Criteria andClientFlagEqualTo(String value) {
            addCriterion("client_flag =", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotEqualTo(String value) {
            addCriterion("client_flag <>", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagGreaterThan(String value) {
            addCriterion("client_flag >", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagGreaterThanOrEqualTo(String value) {
            addCriterion("client_flag >=", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLessThan(String value) {
            addCriterion("client_flag <", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLessThanOrEqualTo(String value) {
            addCriterion("client_flag <=", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLike(String value) {
            addCriterion("client_flag like", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotLike(String value) {
            addCriterion("client_flag not like", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagIn(List<String> values) {
            addCriterion("client_flag in", values, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotIn(List<String> values) {
            addCriterion("client_flag not in", values, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagBetween(String value1, String value2) {
            addCriterion("client_flag between", value1, value2, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotBetween(String value1, String value2) {
            addCriterion("client_flag not between", value1, value2, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andProcNameIsNull() {
            addCriterion("proc_name is null");
            return (Criteria) this;
        }

        public Criteria andProcNameIsNotNull() {
            addCriterion("proc_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcNameEqualTo(String value) {
            addCriterion("proc_name =", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotEqualTo(String value) {
            addCriterion("proc_name <>", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameGreaterThan(String value) {
            addCriterion("proc_name >", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameGreaterThanOrEqualTo(String value) {
            addCriterion("proc_name >=", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLessThan(String value) {
            addCriterion("proc_name <", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLessThanOrEqualTo(String value) {
            addCriterion("proc_name <=", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameLike(String value) {
            addCriterion("proc_name like", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotLike(String value) {
            addCriterion("proc_name not like", value, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameIn(List<String> values) {
            addCriterion("proc_name in", values, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotIn(List<String> values) {
            addCriterion("proc_name not in", values, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameBetween(String value1, String value2) {
            addCriterion("proc_name between", value1, value2, "procName");
            return (Criteria) this;
        }

        public Criteria andProcNameNotBetween(String value1, String value2) {
            addCriterion("proc_name not between", value1, value2, "procName");
            return (Criteria) this;
        }

        public Criteria andProcVersionIsNull() {
            addCriterion("proc_version is null");
            return (Criteria) this;
        }

        public Criteria andProcVersionIsNotNull() {
            addCriterion("proc_version is not null");
            return (Criteria) this;
        }

        public Criteria andProcVersionEqualTo(String value) {
            addCriterion("proc_version =", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionNotEqualTo(String value) {
            addCriterion("proc_version <>", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionGreaterThan(String value) {
            addCriterion("proc_version >", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionGreaterThanOrEqualTo(String value) {
            addCriterion("proc_version >=", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionLessThan(String value) {
            addCriterion("proc_version <", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionLessThanOrEqualTo(String value) {
            addCriterion("proc_version <=", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionLike(String value) {
            addCriterion("proc_version like", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionNotLike(String value) {
            addCriterion("proc_version not like", value, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionIn(List<String> values) {
            addCriterion("proc_version in", values, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionNotIn(List<String> values) {
            addCriterion("proc_version not in", values, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionBetween(String value1, String value2) {
            addCriterion("proc_version between", value1, value2, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcVersionNotBetween(String value1, String value2) {
            addCriterion("proc_version not between", value1, value2, "procVersion");
            return (Criteria) this;
        }

        public Criteria andProcIdIsNull() {
            addCriterion("proc_id is null");
            return (Criteria) this;
        }

        public Criteria andProcIdIsNotNull() {
            addCriterion("proc_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcIdEqualTo(Long value) {
            addCriterion("proc_id =", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdNotEqualTo(Long value) {
            addCriterion("proc_id <>", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdGreaterThan(Long value) {
            addCriterion("proc_id >", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("proc_id >=", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdLessThan(Long value) {
            addCriterion("proc_id <", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdLessThanOrEqualTo(Long value) {
            addCriterion("proc_id <=", value, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdIn(List<Long> values) {
            addCriterion("proc_id in", values, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdNotIn(List<Long> values) {
            addCriterion("proc_id not in", values, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdBetween(Long value1, Long value2) {
            addCriterion("proc_id between", value1, value2, "procId");
            return (Criteria) this;
        }

        public Criteria andProcIdNotBetween(Long value1, Long value2) {
            addCriterion("proc_id not between", value1, value2, "procId");
            return (Criteria) this;
        }

        public Criteria andOsIsNull() {
            addCriterion("os is null");
            return (Criteria) this;
        }

        public Criteria andOsIsNotNull() {
            addCriterion("os is not null");
            return (Criteria) this;
        }

        public Criteria andOsEqualTo(String value) {
            addCriterion("os =", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotEqualTo(String value) {
            addCriterion("os <>", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThan(String value) {
            addCriterion("os >", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanOrEqualTo(String value) {
            addCriterion("os >=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThan(String value) {
            addCriterion("os <", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThanOrEqualTo(String value) {
            addCriterion("os <=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLike(String value) {
            addCriterion("os like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotLike(String value) {
            addCriterion("os not like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsIn(List<String> values) {
            addCriterion("os in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotIn(List<String> values) {
            addCriterion("os not in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsBetween(String value1, String value2) {
            addCriterion("os between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotBetween(String value1, String value2) {
            addCriterion("os not between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNull() {
            addCriterion("event_name is null");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNotNull() {
            addCriterion("event_name is not null");
            return (Criteria) this;
        }

        public Criteria andEventNameEqualTo(String value) {
            addCriterion("event_name =", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotEqualTo(String value) {
            addCriterion("event_name <>", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThan(String value) {
            addCriterion("event_name >", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThanOrEqualTo(String value) {
            addCriterion("event_name >=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThan(String value) {
            addCriterion("event_name <", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThanOrEqualTo(String value) {
            addCriterion("event_name <=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLike(String value) {
            addCriterion("event_name like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotLike(String value) {
            addCriterion("event_name not like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameIn(List<String> values) {
            addCriterion("event_name in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotIn(List<String> values) {
            addCriterion("event_name not in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameBetween(String value1, String value2) {
            addCriterion("event_name between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotBetween(String value1, String value2) {
            addCriterion("event_name not between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andNetIpIsNull() {
            addCriterion("net_ip is null");
            return (Criteria) this;
        }

        public Criteria andNetIpIsNotNull() {
            addCriterion("net_ip is not null");
            return (Criteria) this;
        }

        public Criteria andNetIpEqualTo(String value) {
            addCriterion("net_ip =", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpNotEqualTo(String value) {
            addCriterion("net_ip <>", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpGreaterThan(String value) {
            addCriterion("net_ip >", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpGreaterThanOrEqualTo(String value) {
            addCriterion("net_ip >=", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpLessThan(String value) {
            addCriterion("net_ip <", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpLessThanOrEqualTo(String value) {
            addCriterion("net_ip <=", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpLike(String value) {
            addCriterion("net_ip like", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpNotLike(String value) {
            addCriterion("net_ip not like", value, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpIn(List<String> values) {
            addCriterion("net_ip in", values, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpNotIn(List<String> values) {
            addCriterion("net_ip not in", values, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpBetween(String value1, String value2) {
            addCriterion("net_ip between", value1, value2, "netIp");
            return (Criteria) this;
        }

        public Criteria andNetIpNotBetween(String value1, String value2) {
            addCriterion("net_ip not between", value1, value2, "netIp");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andEventCountIsNull() {
            addCriterion("event_count is null");
            return (Criteria) this;
        }

        public Criteria andEventCountIsNotNull() {
            addCriterion("event_count is not null");
            return (Criteria) this;
        }

        public Criteria andEventCountEqualTo(Integer value) {
            addCriterion("event_count =", value, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountNotEqualTo(Integer value) {
            addCriterion("event_count <>", value, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountGreaterThan(Integer value) {
            addCriterion("event_count >", value, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_count >=", value, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountLessThan(Integer value) {
            addCriterion("event_count <", value, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountLessThanOrEqualTo(Integer value) {
            addCriterion("event_count <=", value, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountIn(List<Integer> values) {
            addCriterion("event_count in", values, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountNotIn(List<Integer> values) {
            addCriterion("event_count not in", values, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountBetween(Integer value1, Integer value2) {
            addCriterion("event_count between", value1, value2, "eventCount");
            return (Criteria) this;
        }

        public Criteria andEventCountNotBetween(Integer value1, Integer value2) {
            addCriterion("event_count not between", value1, value2, "eventCount");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Long value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Long value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Long value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Long value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Long value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Long> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Long> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Long value1, Long value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Long value1, Long value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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