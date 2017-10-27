package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.common.model.Result;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface AdminUserService {
    Result<AdminUserLoginBo> login(String userName, String passWord);
    Result<String> loginout();
    Result<AdminUserInfoBo> info(String token);
}
