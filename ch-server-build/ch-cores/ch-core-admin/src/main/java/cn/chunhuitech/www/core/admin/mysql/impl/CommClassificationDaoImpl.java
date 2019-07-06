package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommClassificationDao;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassificationExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.CommClassificationCusMapper;
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

    @Autowired
    private CommClassificationCusMapper commClassificationCusMapper;

    @Override
    public List<CommClassification> fetchClass(CommClassificationPara commClassificationPara, Byte showFlag, Integer classDataType) {
        CommClassificationExample example = new CommClassificationExample();
        CommClassificationExample.Criteria criteria = example.createCriteria();
        //criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        if (showFlag != ConstantCore.STATUS_SHOW_ALL) {
            criteria.andShowFlagEqualTo(showFlag);
        }
        if (showFlag != ConstantCore.STATUS_CLASS_DATA_TYPE_ALL) {
            criteria.andClassDataTypeEqualTo(classDataType);
        }
        criteria.andModifyTimeGreaterThan(commClassificationPara.getSyncTime());
        example.setOrderByClause(" sort_num asc ");
        return commClassificationMapper.selectByExample(example);
    }

    @Override
    public Long getLastModifyTime() {
        return commClassificationCusMapper.getLastModifyTimeSql();
    }

    @Override
    public List<CommClassification> fetchChildren(CommClassificationPara commClassificationPara, Byte showFlag, Integer classDataType) {
        CommClassificationExample example = new CommClassificationExample();
        CommClassificationExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        if (showFlag != ConstantCore.STATUS_SHOW_ALL) {
            criteria.andShowFlagEqualTo(showFlag);
        }
        if (showFlag != ConstantCore.STATUS_CLASS_DATA_TYPE_ALL) {
            criteria.andClassDataTypeEqualTo(classDataType);
        }
        criteria.andParentIdEqualTo(commClassificationPara.getParentId());
        example.setOrderByClause(" sort_num asc ");
        return commClassificationMapper.selectByExample(example);
    }

    @Override
    public List<CommClassification> fetchAll(Byte showFlag, Integer classDataType) {
        CommClassificationExample example = new CommClassificationExample();
        CommClassificationExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        if (showFlag != ConstantCore.STATUS_SHOW_ALL) {
            criteria.andShowFlagEqualTo(showFlag);
        }
        if (showFlag != ConstantCore.STATUS_CLASS_DATA_TYPE_ALL) {
            criteria.andClassDataTypeEqualTo(classDataType);
        }
        example.setOrderByClause(" sort_num asc ");
        return commClassificationMapper.selectByExample(example);
    }

    @Override
    public int insert(CommClassification commClassification) {
        return commClassificationMapper.insert(commClassification);
    }

    @Override
    public CommClassification getById(Integer id) {
        return commClassificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(CommClassification commClassification) {
        return commClassificationMapper.updateByPrimaryKeySelective(commClassification);
    }

    @Override
    public int delete(int id) {
        return commClassificationMapper.deleteByPrimaryKey(id);
    }
}
