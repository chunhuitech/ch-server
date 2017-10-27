package cn.chunhuitech.www.core.admin.mysql.mapper.cus;

import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;

import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminUserRoleCusMapper {
    List<AdminUserRoleModel> getListSql(Map<String, Object> param);
}
