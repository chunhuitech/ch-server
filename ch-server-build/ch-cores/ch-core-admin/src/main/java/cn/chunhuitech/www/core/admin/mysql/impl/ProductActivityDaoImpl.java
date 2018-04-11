package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.ProductActivityDao;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivityExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.ProductActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class ProductActivityDaoImpl implements ProductActivityDao {

    @Autowired
    private ProductActivityMapper productActivityMapper;


    @Override
    public int insert(ProductActivity productActivity) {
        return productActivityMapper.insert(productActivity);
    }

    @Override
    public int update(ProductActivity productActivity) {
        return productActivityMapper.updateByPrimaryKeySelective(productActivity);
    }

    @Override
    public Long existClient(ProductActivity productActivity) {
        ProductActivityExample example = new ProductActivityExample();
        ProductActivityExample.Criteria criteria = example.createCriteria();
        if (productActivity.getUserId() != null && productActivity.getUserId() != 0){
            criteria.andUserIdEqualTo(productActivity.getUserId());
        }
        criteria.andClientFlagEqualTo(productActivity.getClientFlag());

        List<ProductActivity> paList = productActivityMapper.selectByExample(example);
        if (paList == null || paList.size() <= 0) {
            return null;
        }
        return paList.get(0).getId();
    }
}
