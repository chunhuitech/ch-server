package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommRecordDao;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecordExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.CommRecordCusMapper;
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
        example.setOrderByClause(" sort_num asc ");
        return commRecordMapper.selectByExample(example);
    }

    @Override
    public Integer fetchRecordCount(CommRecordPara commRecordPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("classId", commRecordPara.getClassId());
        param.put("syncTime", commRecordPara.getSyncTime());
        return commRecordCusMapper.fetchRecordCountSql(param);
    }

    @Override
    public Long getLastModifyTime() {
        return commRecordCusMapper.getLastModifyTimeSql();
    }

    @Override
    public List<CommRecordPageModel> fetchRecordPage(CommRecordPara commRecordPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("classId", commRecordPara.getClassId());
        List<String> pageList = Arrays.asList(commRecordPara.getPages().split(","));
        param.put("pages", pageList);
        return commRecordCusMapper.fetchRecordPageSql(param);
    }

    @Override
    public Integer fetchRecordPageCount(CommRecordPara commRecordPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("classId", commRecordPara.getClassId());
        return commRecordCusMapper.fetchRecordPageCountSql(param);
    }
}
