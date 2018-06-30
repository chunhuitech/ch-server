package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

import java.util.List;

public class CommPointReadBlockBo {
    List<CommPointReadBlock> dataList;

    public List<CommPointReadBlock> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommPointReadBlock> dataList) {
        this.dataList = dataList;
    }
}