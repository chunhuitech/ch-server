package cn.chunhuitech.www.core.admin.dao;


import cn.chunhuitech.www.core.admin.model.cus.ProductInfoPara;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface ProductInfoDao {
    ProductInfo getNumVersion(String productName, String technologyPlatform);
    List<ProductInfo> getList(ProductInfoPara productInfoPara);
    long getListCount(ProductInfoPara productInfoPara);
    int updateByUp(ProductInfo productInfo);
    int insert(ProductInfo productInfo);
}
