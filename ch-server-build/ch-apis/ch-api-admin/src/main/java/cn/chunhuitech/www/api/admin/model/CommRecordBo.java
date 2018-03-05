package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

import java.util.List;

public class CommRecordBo {
    List<CommRecord> dataList;
    long lastModTime;

    public List<CommRecord> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommRecord> dataList) {
        this.dataList = dataList;
    }

    public long getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(long lastModTime) {
        this.lastModTime = lastModTime;
    }
}