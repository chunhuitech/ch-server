package cn.chunhuitech.www.core.admin.model.cus;

import cn.chunhuitech.www.core.common.annotation.NotNull;

/**
 * Created by hechengjin on 17-10-24.
 */
public class ProductActivityPara {
    private Integer id;
    private Long procId;
    private String os;
    private String eventName;
    private String area;
    private Long startTime;
    private Long endTime;


    @NotNull
    private Integer page;
    @NotNull
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProcId() {
        return procId;
    }

    public void setProcId(Long procId) {
        this.procId = procId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
