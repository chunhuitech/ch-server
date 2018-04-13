package cn.chunhuitech.www.core.admin.model.cus;

import cn.chunhuitech.www.core.common.annotation.NotNull;

/**
 * Created by hechengjin on 17-10-24.
 */
public class ProductActivityPara {
    private Integer id;
    private String procName;
    private Long startTime;
    private Long endTime;

    @NotNull
    private Integer pageStart;
    @NotNull
    private Integer pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
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

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
