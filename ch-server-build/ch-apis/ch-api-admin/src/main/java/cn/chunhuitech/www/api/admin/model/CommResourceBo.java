package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.CommResource;

import java.util.List;

public class CommResourceBo {
    List<CommResource> dataList;
    long lastModTime;

    public List<CommResource> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommResource> dataList) {
        this.dataList = dataList;
    }

    public long getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(long lastModTime) {
        this.lastModTime = lastModTime;
    }
}