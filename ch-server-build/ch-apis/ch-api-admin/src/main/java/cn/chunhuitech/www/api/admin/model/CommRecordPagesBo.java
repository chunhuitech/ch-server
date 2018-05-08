package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageModel;

import java.util.List;

public class CommRecordPagesBo {
    List<CommRecordPageModel> dataList;
    private long totalPage = 0;
    public List<CommRecordPageModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommRecordPageModel> dataList) {
        this.dataList = dataList;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
}