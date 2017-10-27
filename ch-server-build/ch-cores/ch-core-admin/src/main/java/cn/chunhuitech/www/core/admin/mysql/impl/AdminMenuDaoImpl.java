package cn.chunhuitech.www.core.admin.mysql.impl;

import cn.chunhuitech.www.core.admin.dao.AdminMenuDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminMenuPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminMenuSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminMenu;
import cn.chunhuitech.www.core.admin.mysql.mapper.cus.AdminMenuCusMapper;
import cn.chunhuitech.www.core.admin.mysql.mapper.defaults.AdminMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
@Repository
public class AdminMenuDaoImpl implements AdminMenuDao {

    @Autowired
    private AdminMenuMapper adminMenuMapper;
    @Autowired
    private AdminMenuCusMapper adminMenuCusMapper;


    @Override
    public List<AdminMenuSearchModel> getList(AdminMenuPara adminMenuPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", adminMenuPara.getName());
        param.put("systemId", adminMenuPara.getSystemId());
        param.put("pageStart", adminMenuPara.getPageStart());
        param.put("pageSize", adminMenuPara.getPageSize());
        return adminMenuCusMapper.getListSql(param);
    }

    @Override
    public long getListCount(AdminMenuPara adminMenuPara) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", adminMenuPara.getName());
        param.put("systemId", adminMenuPara.getSystemId());
        return adminMenuCusMapper.getListCountSql(param);
    }

    @Override
    public int insert(AdminMenu adminMenu) {
        return adminMenuMapper.insert(adminMenu);
    }

    @Override
    public AdminMenu getById(Integer id) {
        return adminMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(AdminMenu adminMenu) {
        return adminMenuMapper.updateByPrimaryKeySelective(adminMenu);
    }

    @Override
    public int delete(int id) {
        return adminMenuMapper.deleteByPrimaryKey(id);
    }
}
