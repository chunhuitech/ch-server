package cn.chunhuitech.www.core.admin.model.cus;

import cn.chunhuitech.www.core.common.annotation.NotNull;

/**
 * Created by hechengjin on 17-10-24.
 */
public class AdminUserPara {
    private Integer id;
    private String username;

    @NotNull
    private byte status;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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
