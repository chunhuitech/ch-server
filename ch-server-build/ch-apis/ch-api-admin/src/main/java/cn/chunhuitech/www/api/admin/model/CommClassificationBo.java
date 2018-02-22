package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;

import java.util.List;

public class CommClassificationBo {
    List<CommClassification> dataList;

    public List<CommClassification> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommClassification> dataList) {
        this.dataList = dataList;
    }
}