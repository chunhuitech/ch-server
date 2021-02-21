package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.ProductInfoDao;
import cn.chunhuitech.www.core.admin.model.cus.ProductInfoPara;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfoExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.ProductActivityCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.ProductInfoCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class ProductInfoDaoImpl implements ProductInfoDao {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private ProductInfoCusMapper productInfoCusMapper;

    @Override
    public ProductInfo getNumVersion(String productName, String technologyPlatform) {
        ProductInfoExample example = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(productName);
        criteria.andTechnologyPlatformEqualTo(technologyPlatform);

        List<ProductInfo> paList = productInfoMapper.selectByExample(example);
        if (paList == null || paList.size() <= 0) {
            return null;
        }
        return paList.get(0);
    }

    @Override
    public List<ProductInfo> getList(ProductInfoPara productInfoPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", productInfoPara.getName());
        param.put("status", productInfoPara.getStatus());

        param.put("pageStart", productInfoPara.getPage() -1);
        param.put("pageSize", productInfoPara.getLimit());
        return productInfoCusMapper.getListSql(param);
    }

    @Override
    public long getListCount(ProductInfoPara productInfoPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", productInfoPara.getName());
        param.put("status", productInfoPara.getStatus());

        param.put("pageStart", productInfoPara.getPage() -1);
        param.put("pageSize", productInfoPara.getLimit());
        return productInfoCusMapper.getListCountSql(param);
    }

    @Override
    public int updateByUp(ProductInfo productInfo) {
        return productInfoCusMapper.updateByUpSql(productInfo);
    }

    @Override
    public int insert(ProductInfo productInfo) {
            return productInfoMapper.insert(productInfo);
    }

}
