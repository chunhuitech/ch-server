package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.dao.AdminUserRoleDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserExample;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserRole;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserRoleExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.AdminUserRoleCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminUserMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminUserRoleMapper;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class AdminUserRoleDaoImpl implements AdminUserRoleDao {

    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;

    @Autowired
    private AdminUserRoleCusMapper adminUserRoleCusMapper;

    @Override
    public List<AdminUserRoleModel> getList(Integer userId) {
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        return adminUserRoleCusMapper.getListSql(param);
    }

    @Override
    public int insert(AdminUserRole adminUserRole) {
        return adminUserRoleMapper.insertSelective(adminUserRole);
    }

    @Override
    public int deleteByUserId(Integer userId) {
        AdminUserRoleExample example = new AdminUserRoleExample();
        AdminUserRoleExample.Criteria criteria = example.createCriteria();
        if (userId != null && userId !=0){
            criteria.andUserIdEqualTo(userId);
        }
        return adminUserRoleMapper.deleteByExample(example);
    }
}
