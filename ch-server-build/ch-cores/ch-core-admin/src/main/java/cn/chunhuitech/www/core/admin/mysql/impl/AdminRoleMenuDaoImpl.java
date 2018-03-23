package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.AdminRoleDao;
import cn.chunhuitech.www.core.admin.dao.AdminRoleMenuDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRoleMenu;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRoleMenuExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.AdminRoleCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminRoleMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminRoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class AdminRoleMenuDaoImpl implements AdminRoleMenuDao {

    @Autowired
    private AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public int insert(AdminRoleMenu adminRoleMenu) {
        return adminRoleMenuMapper.insert(adminRoleMenu);
    }

    @Override
    public int update(AdminRoleMenu adminRoleMenu) {
        return adminRoleMenuMapper.updateByPrimaryKeySelective(adminRoleMenu);
    }

    @Override
    public int delete(int id) {
        return adminRoleMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByRoleId(Integer roleId) {
        AdminRoleMenuExample example = new AdminRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return adminRoleMenuMapper.deleteByExample(example);
    }

    @Override
    public boolean exist(Integer menuId) {
        AdminRoleMenuExample example = new AdminRoleMenuExample();
        AdminRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andMenuIdEqualTo(menuId);
        return adminRoleMenuMapper.countByExample(example)>0 ? true : false;
    }

    @Override
    public List<AdminRoleMenu> getListByRoleId(Integer roleId) {
        AdminRoleMenuExample example = new AdminRoleMenuExample();
        AdminRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return adminRoleMenuMapper.selectByExample(example);
    }
}
