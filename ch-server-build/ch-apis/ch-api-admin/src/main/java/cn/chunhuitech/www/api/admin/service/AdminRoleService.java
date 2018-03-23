package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.AdminRoleInfoBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.admin.model.AdminRoleSearchBo;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface AdminRoleService {
    Result<AdminRoleSearchBo> getList(AdminRolePara adminRolePara);

    ErrorMessage add(AdminRoleModel adminRoleModel);
    ErrorMessage mod(AdminRoleModel adminRoleModel);
    ErrorMessage del(AdminRolePara adminRolePara);
    Result<AdminRoleInfoBo> getRole(AdminRolePara adminRolePara);
}
