package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.CommCatalogDao;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommCatalog;
import cn.chunhuitech.www.core.admin.model.pojo.CommCatalogExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.CommCatalogMapper;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class CommCatalogDaoImpl implements CommCatalogDao {

    @Autowired
    private CommCatalogMapper commCatalogMapper;

    @Override
    public List<CommCatalog> fetchCatalog(CommCatalogPara commCatalogPara) {
        CommCatalogExample example = new CommCatalogExample();
        CommCatalogExample.Criteria criteria = example.createCriteria();
        if (commCatalogPara.getClassId() != null){
            criteria.andClassIdEqualTo(commCatalogPara.getClassId());
        }
        criteria.andStatusEqualTo(ConstantCore.STATUS_OK);
        example.setOrderByClause(" start_page asc ");
        return commCatalogMapper.selectByExample(example);
    }

}
