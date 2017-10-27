package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.AdminRoleDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.AdminRoleCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class AdminRoleDaoImpl implements AdminRoleDao{

    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private AdminRoleCusMapper adminRoleCusMapper;


    @Override
    public List<AdminRoleSearchModel> getList(AdminRolePara adminRolePara) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", adminRolePara.getName());
        param.put("systemId", adminRolePara.getSystemId());
        param.put("pageStart", adminRolePara.getPageStart());
        param.put("pageSize", adminRolePara.getPageSize());
        return adminRoleCusMapper.getListSql(param);
    }

    @Override
    public long getListCount(AdminRolePara adminRolePara) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", adminRolePara.getName());
        param.put("systemId", adminRolePara.getSystemId());
        return adminRoleCusMapper.getListCountSql(param);
    }

    @Override
    public int insert(AdminRole adminRole) {
        return adminRoleMapper.insert(adminRole);
    }

    @Override
    public AdminRole getById(Integer id) {
        return adminRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(AdminRole adminRole) {
        return adminRoleMapper.updateByPrimaryKeySelective(adminRole);
    }

    @Override
    public int delete(int id) {
        return adminRoleMapper.deleteByPrimaryKey(id);
    }
}
