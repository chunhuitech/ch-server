package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommRecordDao;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecordExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.CommRecordCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommRecordMapper;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class CommRecordDaoImpl implements CommRecordDao {

    @Autowired
    private CommRecordMapper commRecordMapper;

    @Autowired
    private CommRecordCusMapper commRecordCusMapper;

    @Override
    public List<CommRecord> fetchRecord(CommRecordPara commRecordPara) {
        CommRecordExample example = new CommRecordExample();
        CommRecordExample.Criteria criteria = example.createCriteria();
        if (commRecordPara.getClassId() != null){
            criteria.andClassIdEqualTo(commRecordPara.getClassId());
        }
        criteria.andModifyTimeGreaterThan(commRecordPara.getSyncTime());
//        criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        example.setOrderByClause(" sort_num desc ");
        return commRecordMapper.selectByExample(example);
    }

    @Override
    public Long getLastModifyTime() {
        return commRecordCusMapper.getLastModifyTimeSql();
    }
}
