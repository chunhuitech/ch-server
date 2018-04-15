package cn.chunhuitech.www.core.admin.dao;


import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface ProductInfoDao {
    ProductInfo getNumVersion(String productName, String technologyPlatform);
}
