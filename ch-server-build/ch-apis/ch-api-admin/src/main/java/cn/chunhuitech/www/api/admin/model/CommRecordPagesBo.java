package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageBlockModel;

import java.util.List;

public class CommRecordPagesBo {
    List<CommRecordPageBlockModel> dataList;
    private long totalPage = 0;
    public List<CommRecordPageBlockModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommRecordPageBlockModel> dataList) {
        this.dataList = dataList;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
}