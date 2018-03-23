package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.cus.AdminMenuSearchModel;

import java.util.List;

public class AdminMenuSearchBo {
    private long total = 0;
    List<AdminMenuSearchModel> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<AdminMenuSearchModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<AdminMenuSearchModel> dataList) {
        this.dataList = dataList;
    }
}