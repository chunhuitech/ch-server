package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.ProductInfoDao;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfoExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class ProductInfoDaoImpl implements ProductInfoDao {

    @Autowired
    private ProductInfoMapper productInfoMapper;


    @Override
    public Integer getNumVersion(String productName) {
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(productName);

        List<ProductInfo> paList = productInfoMapper.selectByExample(example);
        if (paList == null || paList.size() <= 0) {
            return 0;
        }
        return paList.get(0).getVersionNum();
    }

}