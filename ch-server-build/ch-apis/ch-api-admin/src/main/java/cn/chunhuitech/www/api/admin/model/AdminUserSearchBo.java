package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;

import java.util.List;

public class AdminUserSearchBo {
    private long total = 0;
    List<AdminUserSearchModel> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<AdminUserSearchModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<AdminUserSearchModel> dataList) {
        this.dataList = dataList;
    }
}