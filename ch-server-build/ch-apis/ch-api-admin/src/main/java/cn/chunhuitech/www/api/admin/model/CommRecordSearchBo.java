package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.cus.CommRecordSearchModel;

import java.util.List;

public class CommRecordSearchBo {
    private long total = 0;
    List<CommRecordSearchModel> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<CommRecordSearchModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommRecordSearchModel> dataList) {
        this.dataList = dataList;
    }
}