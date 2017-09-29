package cn.chunhuitech.www.core.xf.model.cus;

import cn.chunhuitech.www.core.common.annotation.NotNull;

public class XfSchoolPara {
    private String name;

    @NotNull
    private byte status;
    @NotNull
    private Integer pageStart;
    @NotNull
    private Integer pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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