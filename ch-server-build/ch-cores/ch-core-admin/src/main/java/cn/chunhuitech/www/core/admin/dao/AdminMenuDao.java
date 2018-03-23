package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.AdminMenuPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminMenuSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminMenu;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminMenuDao {
    List<AdminMenuSearchModel> getList(AdminMenuPara adminMenuPara);
    long getListCount(AdminMenuPara adminMenuPara);

    int insert(AdminMenu adminMenu);
    AdminMenu getById(Integer id);
    int update(AdminMenu adminMenu);
    int delete(int id);
//    List<AdminMenu> getListByRoleId(Integer roleId);
}
