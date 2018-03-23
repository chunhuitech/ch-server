package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.constant.Constant;
import cn.chunhuitech.www.api.admin.model.*;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminMenuDao;
import cn.chunhuitech.www.core.admin.dao.AdminRoleMenuDao;
import cn.chunhuitech.www.core.admin.dao.AdminUserRoleDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserInfoModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    private AdminMenuDao adminMenuDao;

    @Autowired
    private AdminRoleMenuDao adminRoleMenuDao;

    @Autowired
    private AdminUserRoleDao adminUserRoleDao;
    private static final String DEFPASSWORD = DigestUtils.md5Hex("chunhuitech.cn");

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
    public Result<AdminRightInfoBo> rightInfo(String token) {
        Result<AdminRightInfoBo> retResult = new Result<>();
        if (TextUtils.isEmpty(token)) {
            retResult.setCode(ErrorCode.ILLEGAL_EMPTY.getCode());
            retResult.setMsg(ErrorCode.ILLEGAL_EMPTY.getResult());
            return retResult;
        }
        AdminRightInfoBo adminRightInfoBo = new AdminRightInfoBo();
        AdminUser adminUser = adminUserDao.getByToken(token);
        if (adminUser != null){
            adminRightInfoBo.setUserName(adminUser.getUsername());
            List<AdminUserRoleModel> adminUserRoleModelList = adminUserRoleDao.getList(adminUser.getId());
            List<Integer> roleList = new ArrayList<>();
            if (adminUserRoleModelList != null && adminUserRoleModelList.size() > 0) {
                adminUserRoleModelList.stream().forEach(r -> {
                    roleList.add(r.getRoleId());
                });
            }
            List<Integer> roleMenuIdAll = new ArrayList<>();
            for (Integer roleId : roleList) {
                List<AdminRoleMenu> roleMenuList = adminRoleMenuDao.getListByRoleId(roleId);
                for (AdminRoleMenu rm : roleMenuList){
                    roleMenuIdAll.add(rm.getMenuId());
                }
            }
            HashSet menuHSet = new HashSet(roleMenuIdAll);
            roleMenuIdAll.clear();
            roleMenuIdAll.addAll(menuHSet);

            List<AdminMenu> rootMenu = new ArrayList<>();
            for (Integer meid : roleMenuIdAll){
                AdminMenu adminMenu = adminMenuDao.getById(meid);
                rootMenu.add(adminMenu);
            }

            Collections.sort(rootMenu, new Comparator<AdminMenu>() {
                @Override
                public int compare(AdminMenu o1, AdminMenu o2) {
                    int i = o1.getSeq() - o2.getSeq();
                    if(i == 0){
                        return o1.getId() - o2.getId();
                    }
                    return i;
                }
            });

            List<RightMenuTree> menuList = new ArrayList<RightMenuTree>();
            // 先找到所有的一级菜单
            for (AdminMenu am : rootMenu) {
                // 一级菜单没有parentId
                if (am.getParentId()==0) {
                    RightMenuTree rightMenuTree = new RightMenuTree();
                    rightMenuTree.setId(am.getId());
                    rightMenuTree.setParentId(am.getParentId());
                    rightMenuTree.setName(am.getName());
                    rightMenuTree.setPath(am.getPath());
                    rightMenuTree.setIcon(am.getIcon());
                    rightMenuTree.setResUrl(am.getResUrl());
//                    private List<RightMenuTree> children;
                    menuList.add(rightMenuTree);
                }
            }
            // 为一级菜单设置子菜单，getChild是递归调用的
            for (RightMenuTree menu : menuList) {
                menu.setChildren(getChild(menu.getId(), rootMenu));
            }
            adminRightInfoBo.setMenus(menuList);
            retResult.setCode(ErrorCode.SUCCESS.getCode());
            retResult.setMsg(ErrorCode.SUCCESS.getResult());
            retResult.setData(adminRightInfoBo);

        } else {
            retResult.setCode(ErrorCode.USER_NOT_EXIST.getCode());
            retResult.setMsg(ErrorCode.USER_NOT_EXIST.getResult());
        }
        return retResult;
    }

    /**
     * 递归查找子菜单
     *
     * @param id
     *            当前菜单id
     * @param rootMenu
     *            要查找的列表
     * @return
     */
    private List<RightMenuTree> getChild(Integer id, List<AdminMenu> rootMenu) {
        // 子菜单
        List<RightMenuTree> childList = new ArrayList<>();
        for (AdminMenu am : rootMenu) {
        // 遍历所有节点，将父菜单id与传过来的id比较
            if (am.getParentId().equals(id)) {
                RightMenuTree rightMenuTree = new RightMenuTree();
                rightMenuTree.setId(am.getId());
                rightMenuTree.setParentId(am.getParentId());
                rightMenuTree.setName(am.getName());
                rightMenuTree.setPath(am.getPath());
                rightMenuTree.setIcon(am.getIcon());
                rightMenuTree.setResUrl(am.getResUrl());
                childList.add(rightMenuTree);
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (RightMenuTree menu : childList) {// 没有url子菜单还有子菜单
            if (StringUtils.isBlank(menu.getResUrl())) {
                // 递归
                menu.setChildren(getChild(menu.getId(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
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
        adminUser.setPassword(DigestUtils.md5Hex(DEFPASSWORD));
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
    public Result<AdminUserInfoModel> getBaseInfo(String token) {
        Result<AdminUserInfoModel> retResult = new Result<>();
        if (TextUtils.isEmpty(token)) {
            retResult.setCode(ErrorCode.ILLEGAL_EMPTY.getCode());
            retResult.setMsg(ErrorCode.ILLEGAL_EMPTY.getResult());
            return retResult;
        }

        try {
            AdminUserInfoBo adminUserInfoBo = new AdminUserInfoBo();
            AdminUser adminUser = adminUserDao.getByToken(token);
            AdminUserInfoModel adminUserInfoModel = new AdminUserInfoModel();
            adminUserInfoModel.setUsername(adminUser.getUsername());
            adminUserInfoModel.setNickname(adminUser.getNickname());
            adminUserInfoModel.setAvatar(adminUser.getAvatar());
            adminUserInfoModel.setEmail(adminUser.getEmail());
            adminUserInfoModel.setQq(adminUser.getQq());
            adminUserInfoModel.setWeixin(adminUser.getWeixin());
            adminUserInfoModel.setCreateTime(adminUser.getCreateTime());
            adminUserInfoModel.setDes(adminUser.getDes());
            List<AdminUserRoleModel> adminUserRoleModelList = adminUserRoleDao.getList(adminUser.getId());
            String roleNames = "";
            for (AdminUserRoleModel userRole : adminUserRoleModelList) {
                roleNames += userRole.getRoleName() + ",";
            }
            roleNames = roleNames.substring(0, roleNames.length() -1);
            adminUserInfoModel.setRoleNames(roleNames);
            retResult.setData(adminUserInfoModel);
            retResult.setCode(ErrorCode.SUCCESS.getCode());
            retResult.setMsg(ErrorCode.SUCCESS.getResult());
            return retResult;
        }
        catch(Exception ex){
            retResult.setCode(ErrorCode.DB_ERROR.getCode());
            retResult.setMsg(ErrorCode.DB_ERROR.getResult());
            return retResult;
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

    @Override
    public ErrorMessage reset(AdminUserPara adminUserPara) {
        try{
            ValidUtils.validNotNullEx(adminUserPara, "id,username");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        long current = System.currentTimeMillis();
        AdminUser adminUser = new AdminUser();
        adminUser.setId(adminUserPara.getId());
        adminUser.setPassword(DEFPASSWORD);
        DateTime dt = new DateTime();
        adminUser.setToken(DigestUtils.md5Hex(adminUserPara.getUsername() + dt.toString(Constant.DATETIME_FORMAT)));
        int operRes = adminUserDao.update(adminUser);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }
}
