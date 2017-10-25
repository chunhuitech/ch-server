package cn.chunhuitech.www.api.xf.model;

import cn.chunhuitech.www.core.xf.model.pojo.XfSchool;

import java.util.List;

public class XfSchoolModelSearch {
    private long total = 0;
    List<XfSchool> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<XfSchool> getDataList() {
        return dataList;
    }

    public void setDataList(List<XfSchool> dataList) {
        this.dataList = dataList;
    }
}