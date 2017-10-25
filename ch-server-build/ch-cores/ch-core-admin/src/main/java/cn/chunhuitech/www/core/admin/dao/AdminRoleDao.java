package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.AdminRoleCus;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminRoleDao {
    List<AdminRoleCus> getList(AdminRolePara adminRolePara);
    long getListCount(AdminRolePara adminRolePara);

    int insert(AdminRole adminRole);
    AdminRole getById(Integer id);
    int update(AdminRole adminRole);
    int delete(int id);
}
