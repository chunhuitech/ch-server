package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommPointReadBlockDao;
import cn.chunhuitech.www.core.admin.dao.CommRecordDao;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageBlockModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlockExample;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecordExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.CommRecordCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommPointReadBlockMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class CommPointReadBlockDaoImpl implements CommPointReadBlockDao {

    @Autowired
    private CommPointReadBlockMapper commPointReadBlockMapper;

    @Override
    public int insert(CommPointReadBlock commPointReadBlock) {
        return commPointReadBlockMapper.insert(commPointReadBlock);
    }

    @Override
    public int update(CommPointReadBlock commPointReadBlock) {
        return commPointReadBlockMapper.updateByPrimaryKeySelective(commPointReadBlock);
    }

    @Override
    public int delete(int id) {
        return commPointReadBlockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByRecordId(Integer recordId) {
        CommPointReadBlockExample example = new CommPointReadBlockExample();
        example.createCriteria().andRecordIdEqualTo(recordId);
        return commPointReadBlockMapper.deleteByExample(example);
    }
}
