package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;

import java.util.List;

public class ProductActivitySearchBo {
    private long total = 0;
    List<ProductActivity> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<ProductActivity> getDataList() {
        return dataList;
    }

    public void setDataList(List<ProductActivity> dataList) {
        this.dataList = dataList;
    }
}