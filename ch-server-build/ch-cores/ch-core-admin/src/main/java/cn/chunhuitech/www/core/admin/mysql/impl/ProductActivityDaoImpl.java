package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.ProductActivityDao;
import cn.chunhuitech.www.core.admin.model.cus.ProductActivityPara;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivityExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.ProductActivityCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.ProductActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class ProductActivityDaoImpl implements ProductActivityDao {

    @Autowired
    private ProductActivityMapper productActivityMapper;

    @Autowired
    private ProductActivityCusMapper productActivityCusMapper;


    @Override
    public int insert(ProductActivity productActivity) {
        return productActivityMapper.insert(productActivity);
    }

    @Override
    public int update(ProductActivity productActivity) {
        return productActivityMapper.updateByPrimaryKeySelective(productActivity);
    }

    @Override
    public int updateByUp(ProductActivity productActivity) {
        return productActivityCusMapper.updateByUpSql(productActivity);
    }

    @Override
    public ProductActivity existClient(ProductActivity productActivity) {
        ProductActivityExample example = new ProductActivityExample();
        ProductActivityExample.Criteria criteria = example.createCriteria();
        if (productActivity.getUserId() != null && productActivity.getUserId() != 0){
            criteria.andUserIdEqualTo(productActivity.getUserId());
        }
        criteria.andClientFlagEqualTo(productActivity.getClientFlag()).andProcIdEqualTo(productActivity.getProcId());

        List<ProductActivity> paList = productActivityMapper.selectByExample(example);
        if (paList == null || paList.size() <= 0) {
            return null;
        }
        return paList.get(0);
    }

    @Override
    public List<ProductActivity> getList(ProductActivityPara productActivityPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("procId", productActivityPara.getProcId());
        param.put("os", productActivityPara.getOs());
        param.put("eventName", productActivityPara.getEventName());
        param.put("area", productActivityPara.getArea());
        param.put("startTime", productActivityPara.getStartTime());
        param.put("endTime", productActivityPara.getEndTime());
        param.put("pageStart", productActivityPara.getPage() -1);
        param.put("pageSize", productActivityPara.getLimit());
        return productActivityCusMapper.getListSql(param);
    }

    @Override
    public long getListCount(ProductActivityPara productActivityPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("procId", productActivityPara.getProcId());
        param.put("os", productActivityPara.getOs());
        param.put("eventName", productActivityPara.getEventName());
        param.put("area", productActivityPara.getArea());
        param.put("startTime", productActivityPara.getStartTime());
        param.put("endTime", productActivityPara.getEndTime());
        return productActivityCusMapper.getListCountSql(param);
    }
}
