package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.core.admin.dao.AdminUserRoleDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserDao adminUserDao;

    @Autowired
    private AdminUserRoleDao adminUserRoleDao;

    @Override
    public Result<AdminUserLoginBo> login(String userName, String passWord) {
        Result<AdminUserLoginBo> retResult = new Result<>();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            retResult.setCode(ErrorCode.ILLEGAL_EMPTY.getCode());
            retResult.setMsg(ErrorCode.ILLEGAL_EMPTY.getResult());
            return retResult;
        }
        AdminUserLoginBo adminUserModelLogin = new AdminUserLoginBo();
        AdminUser adminUser = adminUserDao.getByUserName(userName);
        if (adminUser != null){
            String md5PassWord = DigestUtils.md5Hex(passWord);
            if (md5PassWord.equalsIgnoreCase(adminUser.getPassword())) {
                adminUserModelLogin.setToken(adminUser.getToken());
                retResult.setCode(ErrorCode.SUCCESS.getCode());
                retResult.setMsg(ErrorCode.SUCCESS.getResult());
                retResult.setData(adminUserModelLogin);
            } else {
                retResult.setCode(ErrorCode.USER_PASSWORD_ERROR.getCode());
                retResult.setMsg(ErrorCode.USER_PASSWORD_ERROR.getResult());
            }

        } else {
            retResult.setCode(ErrorCode.USER_NOT_EXIST.getCode());
            retResult.setMsg(ErrorCode.USER_NOT_EXIST.getResult());
        }
        return retResult;
    }

    @Override
    public Result<String> loginout() {
        Result<String> retResult = new Result<>();
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(ErrorCode.SUCCESS.getResult());
        return retResult;
    }

    @Override
    public Result<AdminUserInfoBo> info(String token) {
        Result<AdminUserInfoBo> retResult = new Result<>();
        if (TextUtils.isEmpty(token)) {
            retResult.setCode(ErrorCode.ILLEGAL_EMPTY.getCode());
            retResult.setMsg(ErrorCode.ILLEGAL_EMPTY.getResult());
            return retResult;
        }
        AdminUserInfoBo adminUserInfoBo = new AdminUserInfoBo();
        AdminUser adminUser = adminUserDao.getByToken(token);
        if (adminUser != null){
            adminUserInfoBo.setName(adminUser.getUsername());
            adminUserInfoBo.setAvatar(adminUser.getAvatar());
            List<AdminUserRoleModel> adminUserRoleModelList = adminUserRoleDao.getList(adminUser.getId());
            List<String> roleList = new ArrayList<>();
            if (adminUserRoleModelList != null && adminUserRoleModelList.size() > 0) {
                adminUserRoleModelList.stream().forEach(r -> {
                    roleList.add(r.getRoleName());
                });
            }
            adminUserInfoBo.setRole(roleList);
            retResult.setCode(ErrorCode.SUCCESS.getCode());
            retResult.setMsg(ErrorCode.SUCCESS.getResult());
            retResult.setData(adminUserInfoBo);

        } else {
            retResult.setCode(ErrorCode.USER_NOT_EXIST.getCode());
            retResult.setMsg(ErrorCode.USER_NOT_EXIST.getResult());
        }
        return retResult;
    }
}
