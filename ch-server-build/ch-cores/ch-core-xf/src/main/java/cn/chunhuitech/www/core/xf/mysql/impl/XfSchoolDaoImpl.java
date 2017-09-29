package cn.chunhuitech.www.core.xf.mysql.impl;


import cn.chunhuitech.www.core.common.constant.ConstantCore;
import cn.chunhuitech.www.core.xf.dao.XfSchoolDao;
import cn.chunhuitech.www.core.xf.model.cus.XfSchoolPara;
import cn.chunhuitech.www.core.xf.model.pojo.XfSchool;
import cn.chunhuitech.www.core.xf.model.pojo.XfSchoolExample;
import cn.chunhuitech.www.core.xf.mysql.mapper.defaults.XfSchoolMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Repository
public class XfSchoolDaoImpl implements XfSchoolDao {
    @Autowired
    private XfSchoolMapper xfSchoolMapper;


    private XfSchoolExample getListExample(XfSchoolPara xfSchoolPara) {
        XfSchoolExample example = new XfSchoolExample();
        XfSchoolExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(xfSchoolPara.getName())) {
            String name = "%" + xfSchoolPara.getName() + "%";
            criteria.andNameLike(name);
        }
        if (xfSchoolPara.getStatus() != ConstantCore.STATUS_INVALID) {
            criteria.andStatusEqualTo(xfSchoolPara.getStatus());
        }
        return example;
    }



    @Override
    public List<XfSchool> getList(XfSchoolPara xfSchoolPara) {
        XfSchoolExample example = getListExample(xfSchoolPara);
        example.setOrderByClause(" id desc limit " + xfSchoolPara.getPageStart() + ", " + xfSchoolPara.getPageSize());
        return xfSchoolMapper.selectByExample(example);
    }

    @Override
    public long getListCount(XfSchoolPara xfSchoolPara) {
        XfSchoolExample example = getListExample(xfSchoolPara);
        return xfSchoolMapper.countByExample(example);
    }
}
