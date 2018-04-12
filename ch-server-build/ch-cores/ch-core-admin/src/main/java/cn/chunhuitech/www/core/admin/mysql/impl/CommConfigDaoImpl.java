package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommConfigDao;
import cn.chunhuitech.www.core.admin.model.pojo.CommConfig;
import cn.chunhuitech.www.core.admin.model.pojo.CommConfigExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommConfigMapper;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class CommConfigDaoImpl implements CommConfigDao {

    @Autowired
    private CommConfigMapper commConfigMapper;

    @Override
    public Integer getRecordDataVersion(String keyName) {
        List<CommConfig> paList = getConfigList(keyName);
        if(paList == null){
            return Integer.valueOf(0);
        }
        return Integer.valueOf(paList.get(0).getValueInfo());
    }

    private List<CommConfig> getConfigList(String keyName) {
        CommConfigExample example = new CommConfigExample();
        CommConfigExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        criteria.andKeyNameEqualTo(keyName);

        List<CommConfig> paList = commConfigMapper.selectByExample(example);
        if (paList == null || paList.size() <= 0) {
            return null;
        }
        return  paList;
    }

    @Override
    public String getRecordDataDownAddr(String keyName) {
        List<CommConfig> paList = getConfigList(keyName);
        if(paList == null){
            return "";
        }
        return paList.get(0).getValueInfo();
    }
}
