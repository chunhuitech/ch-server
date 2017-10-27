package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserRole;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminUserRoleDao {
    List<AdminUserRoleModel> getList(Integer userId);
}
