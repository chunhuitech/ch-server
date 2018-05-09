package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.CommCatalog;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

import java.util.List;

public class CommCatalogBo {
    List<CommCatalog> dataList;

    public List<CommCatalog> getDataList() {
        return dataList;
    }

    public void setDataList(List<CommCatalog> dataList) {
        this.dataList = dataList;
    }
}