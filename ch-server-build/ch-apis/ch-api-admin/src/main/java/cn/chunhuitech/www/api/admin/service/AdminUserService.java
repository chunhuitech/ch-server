package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminUserSearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface AdminUserService {
    Result<AdminUserLoginBo> login(String userName, String passWord);
    Result<String> loginout();
    Result<AdminUserInfoBo> info(String token);

    Result<AdminUserSearchBo> getList(AdminUserPara adminUserPara);
    ErrorMessage add(AdminUserSearchModel adminUserSearchModel);
    ErrorMessage mod(AdminUserSearchModel adminUserSearchModel);
    ErrorMessage del(AdminUserPara adminUserPara);

    Result<AdminUserSearchModel>  getModel(AdminUserPara adminUserPara);
    Result<Boolean> exist(AdminUserPara adminUserPara);
}
