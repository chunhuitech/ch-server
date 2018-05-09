package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommResourceDao;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommResource;
import cn.chunhuitech.www.core.admin.model.pojo.CommResourceExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommResourceMapper;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class CommResourceDaoImpl implements CommResourceDao {

    @Autowired
    private CommResourceMapper commResourceMapper;

    @Override
    public List<CommResource> fetchResource(CommClassificationPara commClassificationPara) {
        CommResourceExample example = new CommResourceExample();
        CommResourceExample.Criteria criteria = example.createCriteria();
        if (commClassificationPara.getId() != null){
            criteria.andClassIdEqualTo(commClassificationPara.getId());
        }
        criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        example.setOrderByClause(" sort_num asc ");
        return commResourceMapper.selectByExample(example);
    }


}
