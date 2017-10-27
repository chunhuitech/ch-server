package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.AdminSystemDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminSystemPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminSystem;
import cn.chunhuitech.www.core.admin.model.pojo.AdminSystemExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminSystemMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class AdminSystemDaoImpl implements AdminSystemDao {

    @Autowired
    private AdminSystemMapper adminSystemMapper;


    private AdminSystemExample getListExample(AdminSystemPara adminSystemPara) {
        AdminSystemExample example = new AdminSystemExample();
        AdminSystemExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(adminSystemPara.getName())) {
            String name = "%" + adminSystemPara.getName() + "%";
            criteria.andNameLike(name);
        }
        return example;
    }


    @Override
    public List<AdminSystem> getList(AdminSystemPara adminSystemPara) {
        AdminSystemExample example = getListExample(adminSystemPara);
        example.setOrderByClause(" id desc limit " + adminSystemPara.getPageStart() + ", " + adminSystemPara.getPageSize());
        return adminSystemMapper.selectByExample(example);
    }

    @Override
    public long getListCount(AdminSystemPara adminSystemPara) {
        AdminSystemExample example = getListExample(adminSystemPara);
        return adminSystemMapper.countByExample(example);
    }

    @Override
    public int insert(AdminSystem adminSystem) {
        return adminSystemMapper.insert(adminSystem);
    }

    @Override
    public AdminSystem getById(Integer id) {
        return  adminSystemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(AdminSystem adminSystem) {
        return adminSystemMapper.updateByPrimaryKeySelective(adminSystem);
    }

    @Override
    public int delete(int id) {
        return adminSystemMapper.deleteByPrimaryKey(id);
    }
}
