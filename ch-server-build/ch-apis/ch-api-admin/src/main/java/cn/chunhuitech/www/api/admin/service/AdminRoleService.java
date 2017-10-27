package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.admin.model.AdminRoleSearchBo;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface AdminRoleService {
    Result<AdminRoleSearchBo> getList(AdminRolePara adminRolePara);

    ErrorMessage add(AdminRole adminRole);
    ErrorMessage mod(AdminRole adminRole);
    ErrorMessage del(AdminRolePara adminRolePara);
}
