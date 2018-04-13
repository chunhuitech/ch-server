package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.ProductActivityPara;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;

import java.util.List;


/**
 * Created by hechengjin on 17-10-24.
 */
public interface ProductActivityDao {
    int insert(ProductActivity productActivity);
    Long existClient(ProductActivity productActivity);
    int update(ProductActivity productActivity);

    List<ProductActivity> getList(ProductActivityPara productActivityPara);
    long getListCount(ProductActivityPara productActivityPara);
}
