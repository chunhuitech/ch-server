package cn.chunhuitech.www.api.admin.model;

import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;

import java.util.List;

public class ProductInfoSearchBo {
    private long total = 0;
    List<ProductInfo> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<ProductInfo> getDataList() {
        return dataList;
    }

    public void setDataList(List<ProductInfo> dataList) {
        this.dataList = dataList;
    }
}