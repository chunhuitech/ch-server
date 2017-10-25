package cn.chunhuitech.www.core.admin.model.cus;

import cn.chunhuitech.www.core.common.annotation.NotNull;

/**
 * Created by hechengjin on 17-10-24.
 */
public class AdminRolePara {
    private Integer id;
    private String name;
    private Integer systemId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
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
