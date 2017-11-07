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
    private Integer page;
    @NotNull
    private Integer limit;

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
