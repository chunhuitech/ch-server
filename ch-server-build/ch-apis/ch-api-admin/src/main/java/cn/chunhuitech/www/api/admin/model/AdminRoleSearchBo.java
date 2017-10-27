package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;

import java.util.List;

public class AdminRoleSearchBo {
    private long total = 0;
    List<AdminRoleSearchModel> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<AdminRoleSearchModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<AdminRoleSearchModel> dataList) {
        this.dataList = dataList;
    }
}