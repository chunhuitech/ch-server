package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.pojo.AdminRoleMenu;

import java.util.List;


/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminRoleMenuDao {
    int insert(AdminRoleMenu adminRoleMenu);
    int update(AdminRoleMenu adminRoleMenu);
    int delete(int id);
    int deleteByRoleId(Integer roleId);
    boolean exist(Integer menuId);
    List<AdminRoleMenu> getListByRoleId(Integer roleId);
}
