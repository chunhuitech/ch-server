package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

import java.util.List;

public class CommRecordWebSearchBo {
    private long total = 0;
    List<CommRecord> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<CommRecord> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommRecord> dataList) {
        this.dataList = dataList;
    }
}