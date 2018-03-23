package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.AdminMenuSearchBo;
import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.admin.model.AdminUserSearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminMenuPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminMenu;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface AdminMenuService {

    Result<AdminMenuSearchBo> getList(AdminMenuPara adminMenuPara);
    ErrorMessage add(AdminMenu adminMenu);
    ErrorMessage mod(AdminMenu adminMenu);
    ErrorMessage del(AdminMenuPara adminMenuPara);

    Result<AdminMenu>  getModel(AdminMenuPara adminMenuPara);
}
