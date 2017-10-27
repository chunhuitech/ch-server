package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.AdminSystem;

import java.util.List;

public class AdminSystemSearchBo {
    private long total = 0;
    List<AdminSystem> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<AdminSystem> getDataList() {
        return dataList;
    }

    public void setDataList(List<AdminSystem> dataList) {
        this.dataList = dataList;
    }
}