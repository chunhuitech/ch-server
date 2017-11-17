package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.constant.Constant;
import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminUserSearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminUserRoleDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUserRole;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.util.TextUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@SuppressWarnings("all")
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

    @Override
    public Result<AdminUserSearchBo> getList(AdminUserPara adminUserPara) {
        Result<AdminUserSearchBo> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(adminUserPara);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        AdminUserSearchBo modelResult = new AdminUserSearchBo();
        long count = adminUserDao.getListCount(adminUserPara);
        modelResult.setTotal(count);
        List<AdminUser> dataList = adminUserDao.getList(adminUserPara);
        List<AdminUserSearchModel> modelList = new ArrayList<>();
        if (dataList != null && dataList.size() > 0) {
            dataList.stream().forEach(r -> {
                AdminUserSearchModel adminUserSearchModel = new AdminUserSearchModel();
                adminUserSearchModel.setId(r.getId());
                adminUserSearchModel.setUsername(r.getUsername());
                adminUserSearchModel.setNickname(r.getNickname());
                adminUserSearchModel.setAvatar(r.getAvatar());
                adminUserSearchModel.setEmail(r.getEmail());
                adminUserSearchModel.setQq(r.getQq());
                adminUserSearchModel.setWeixin(r.getWeixin());
                adminUserSearchModel.setModifyTime(r.getModifyTime());
                adminUserSearchModel.setCreateTime(r.getCreateTime());
                adminUserSearchModel.setStatus(r.getStatus());
                adminUserSearchModel.setDes(r.getDes());
                List<AdminUserRoleModel> adminUserRoleModelList = adminUserRoleDao.getList(r.getId());
                adminUserSearchModel.setRoles(adminUserRoleModelList);
                modelList.add(adminUserSearchModel);
            });
        }
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    @Transactional
    @Override
    public ErrorMessage add(AdminUserSearchModel adminUserSearchModel) {
        try {
            ValidUtils.validNotNullEx(adminUserSearchModel, "username,nickname");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(adminUserSearchModel.getUsername());
        adminUser.setPassword(DigestUtils.md5Hex("cunhuitech.cn"));
        DateTime dt = new DateTime();
        adminUser.setToken(DigestUtils.md5Hex(adminUserSearchModel.getUsername() + dt.toString(Constant.DATETIME_FORMAT)));
        adminUser.setNickname(adminUserSearchModel.getNickname());
        adminUser.setAvatar(adminUserSearchModel.getAvatar());
        adminUser.setEmail(adminUserSearchModel.getEmail());
        adminUser.setQq(adminUserSearchModel.getQq());
        adminUser.setWeixin(adminUserSearchModel.getWeixin());
        adminUser.setStatus(adminUserSearchModel.getStatus());
        adminUser.setDes(adminUserSearchModel.getDes());
        long nowTime = System.currentTimeMillis();
        adminUser.setModifyTime(nowTime);
        adminUser.setCreateTime(nowTime);
        int operRes = adminUserDao.insert(adminUser);
        if(operRes > 0) {
            for (Integer roleId : adminUserSearchModel.getRoleIds()) {
                AdminUserRole adminUserRole = new AdminUserRole();
                adminUserRole.setUserId(adminUser.getId());
                adminUserRole.setRoleId(roleId);
                operRes = adminUserRoleDao.insert(adminUserRole);
                if (operRes < 0) {
                    return ErrorCode.DB_ERROR;
                }
            }
        }
        else {
            return ErrorCode.DB_ERROR;
        }
            return ErrorCode.SUCCESS;
    }

    @Transactional
    @Override
    public ErrorMessage mod(AdminUserSearchModel adminUserSearchModel) {
        try {
            ValidUtils.validNotNullEx(adminUserSearchModel, "id,username,nickname");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        AdminUser adminUser = new AdminUser();
        adminUser.setId(adminUserSearchModel.getId());
        adminUser.setUsername(adminUserSearchModel.getUsername());
        adminUser.setNickname(adminUserSearchModel.getNickname());
        adminUser.setAvatar(adminUserSearchModel.getAvatar());
        adminUser.setEmail(adminUserSearchModel.getEmail());
        adminUser.setQq(adminUserSearchModel.getQq());
        adminUser.setWeixin(adminUserSearchModel.getWeixin());
        adminUser.setStatus(adminUserSearchModel.getStatus());
        adminUser.setDes(adminUserSearchModel.getDes());
        adminUser.setModifyTime(System.currentTimeMillis());
        int operRes = adminUserDao.update(adminUser);
        if(operRes > 0){
            adminUserRoleDao.deleteByUserId(adminUser.getId());
            for (Integer roleId : adminUserSearchModel.getRoleIds()) {
                AdminUserRole adminUserRole = new AdminUserRole();
                adminUserRole.setUserId(adminUser.getId());
                adminUserRole.setRoleId(roleId);
                operRes = adminUserRoleDao.insert(adminUserRole);
                if (operRes < 0) {
                    return ErrorCode.DB_ERROR;
                }
            }
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage del(AdminUserPara adminUserPara) {
        try{
            ValidUtils.validNotNullEx(adminUserPara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = adminUserDao.delete(adminUserPara.getId());
        if(operRes > 0){
            adminUserRoleDao.deleteByUserId(adminUserPara.getId());
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public Result<AdminUserSearchModel> getModel(AdminUserPara adminUserPara) {
        Result<AdminUserSearchModel> getModelResult = new Result<>();
        try{
            ValidUtils.validNotNullEx(adminUserPara, "id");
        } catch (Exception ex){
            getModelResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            getModelResult.setMsg(ex.getMessage());
            return getModelResult;
        }
        AdminUserSearchModel adminUserSearchModel = new AdminUserSearchModel();
        try {
            AdminUser adminUser = adminUserDao.getById(adminUserPara.getId());
            adminUserSearchModel.setId(adminUser.getId());
            adminUserSearchModel.setUsername(adminUser.getUsername());
            adminUserSearchModel.setNickname(adminUser.getNickname());
            adminUserSearchModel.setAvatar(adminUser.getAvatar());
            adminUserSearchModel.setEmail(adminUser.getEmail());
            adminUserSearchModel.setQq(adminUser.getQq());
            adminUserSearchModel.setWeixin(adminUser.getWeixin());
            adminUserSearchModel.setStatus(adminUser.getStatus());
            adminUserSearchModel.setDes(adminUser.getDes());

            List<AdminUserRoleModel> adminUserRoleModelList = adminUserRoleDao.getList(adminUser.getId());
            adminUserSearchModel.setRoles(adminUserRoleModelList);
            getModelResult.setData(adminUserSearchModel);
            getModelResult.setCode(ErrorCode.SUCCESS.getCode());
            getModelResult.setMsg(ErrorCode.SUCCESS.getResult());
            return getModelResult;
        }
        catch(Exception ex){
            getModelResult.setCode(ErrorCode.DB_ERROR.getCode());
            getModelResult.setMsg(ErrorCode.DB_ERROR.getResult() + " " + ex.getMessage());
            return getModelResult;
        }
    }

    @Override
    public Result<Boolean> exist(AdminUserPara adminUserPara) {
        Result<Boolean> retResult = new Result<>();
        try{
            ValidUtils.validNotNullEx(adminUserPara, "username");
        } catch (Exception ex){
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            return retResult;
        }

        boolean exist = adminUserDao.exist(adminUserPara.getId(), adminUserPara.getUsername());
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(exist);
        return retResult;
    }
}
