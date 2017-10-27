package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.AdminSystemSearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminSystemPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminSystem;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface AdminSystemService {
    Result<AdminSystemSearchBo> getList(AdminSystemPara adminSystemPara);

    ErrorMessage add(AdminSystem adminSystem);
    ErrorMessage mod(AdminSystem adminSystem);
    ErrorMessage del(AdminSystemPara adminSystemPara);
}
