package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;

import java.util.List;

public class CommClassificationBo {
    List<CommClassification> dataList;
    long lastModTime;

    public List<CommClassification> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommClassification> dataList) {
        this.dataList = dataList;
    }

    public long getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(long lastModTime) {
        this.lastModTime = lastModTime;
    }
}