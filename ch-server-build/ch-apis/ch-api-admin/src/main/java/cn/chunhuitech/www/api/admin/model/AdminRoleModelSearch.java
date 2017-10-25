package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.cus.AdminRoleCus;

import java.util.List;

public class AdminRoleModelSearch {
    private long total = 0;
    List<AdminRoleCus> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<AdminRoleCus> getDataList() {
        return dataList;
    }

    public void setDataList(List<AdminRoleCus> dataList) {
        this.dataList = dataList;
    }
}