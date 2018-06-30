package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserExample;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminUserMapper;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class AdminUserDaoImpl implements AdminUserDao {

    @Autowired
    private AdminUserMapper adminUserMapper;

    private AdminUserExample getListExample(AdminUserPara adminUserPara) {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(adminUserPara.getUsername())) {
            String userName = "%" + adminUserPara.getUsername() + "%";
            criteria.andUsernameLike(userName);
        }
        if (adminUserPara.getStatus() != ConstantCore.STATUS_INVALID) {
            criteria.andStatusEqualTo(adminUserPara.getStatus());
        }
        return example;
    }

    @Override
    public List<AdminUser> getList(AdminUserPara aminUserPara) {
        AdminUserExample example = getListExample(aminUserPara);
        example.setOrderByClause(" id desc limit " + (aminUserPara.getPage() - 1) * aminUserPara.getLimit() + ", " + aminUserPara.getLimit());
        return adminUserMapper.selectByExample(example);
    }

    @Override
    public long getListCount(AdminUserPara adminUserPara) {
        AdminUserExample example = getListExample(adminUserPara);
        return adminUserMapper.countByExample(example);
    }

    @Override
    public long getWxUserCount() {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdIsNotNull();
        return  adminUserMapper.countByExample(example);
    }

    @Override
    public int insert(AdminUser adminUser) {
        return adminUserMapper.insert(adminUser);
    }

    @Override
    public AdminUser getById(Integer id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public AdminUser getByUserName(String username) {
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<AdminUser> modelList = adminUserMapper.selectByExample(example);
        if (modelList != null && !modelList.isEmpty()) {
            return modelList.get(0);
        }
        return null;
    }

    @Override
    public AdminUser getByToken(String token) {
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andTokenEqualTo(token);
        List<AdminUser> modelList = adminUserMapper.selectByExample(example);
        if (modelList != null && !modelList.isEmpty()) {
            return modelList.get(0);
        }
        return null;
    }

    @Override
    public AdminUser getByOpenId(String OpenId) {
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andOpenIdEqualTo(OpenId);
        List<AdminUser> modelList = adminUserMapper.selectByExample(example);
        if (modelList != null && !modelList.isEmpty()) {
            return modelList.get(0);
        }
        return null;
    }

    @Override
    public int update(AdminUser adminUser) {
        return adminUserMapper.updateByPrimaryKeySelective(adminUser);
    }

    @Override
    public int delete(int id) {
        AdminUser adminUser = getById(id);
        adminUser.setStatus(ConstantCore.STATUS_DELETE);
        return adminUserMapper.updateByPrimaryKeySelective(adminUser);
    }

    @Override
    public boolean exist(Integer id, String userName) {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        if (id != null && id > 0) {
            criteria.andIdNotEqualTo(id);
        }
        return adminUserMapper.countByExample(example)>0 ? true : false;
    }

    @Override
    public boolean verifyUser(Integer id, String userName) {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        if (id != null && id > 0) {
            criteria.andIdEqualTo(id);
        }
        return adminUserMapper.countByExample(example)>0 ? true : false;
    }

    @Override
    public boolean existByOpenId(String openId) {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(openId);
        return adminUserMapper.countByExample(example)>0 ? true : false;
    }
}
