package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommClassificationDao;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassificationExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommClassificationMapper;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class CommClassificationDaoImpl implements CommClassificationDao {

    @Autowired
    private CommClassificationMapper commClassificationMapper;

    @Override
    public List<CommClassification> fetchClass(CommClassificationPara commClassificationPara) {
        CommClassificationExample example = new CommClassificationExample();
        CommClassificationExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        example.setOrderByClause(" sort_num desc ");
        return commClassificationMapper.selectByExample(example);
    }
}
