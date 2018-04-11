package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;


/**
 * Created by hechengjin on 17-10-24.
 */
public interface ProductActivityDao {
    int insert(ProductActivity productActivity);
    Long existClient(ProductActivity productActivity);
    int update(ProductActivity productActivity);
}
