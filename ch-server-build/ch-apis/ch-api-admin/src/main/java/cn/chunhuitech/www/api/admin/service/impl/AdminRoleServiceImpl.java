package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.AdminRoleInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminRoleSearchBo;
import cn.chunhuitech.www.api.admin.model.RightMenuTree;
import cn.chunhuitech.www.api.admin.service.AdminRoleService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminMenuDao;
import cn.chunhuitech.www.core.admin.dao.AdminRoleDao;
import cn.chunhuitech.www.core.admin.dao.AdminRoleMenuDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminMenu;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRoleMenu;
import org.apache.commons.lang3.StringUtils;
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
public class AdminRoleServiceImpl implements AdminRoleService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminRoleDao adminRoleDao;
    @Autowired
    private AdminMenuDao adminMenuDao;

    @Autowired
    private AdminRoleMenuDao adminRoleMenuDao;

    @Override
    public Result<AdminRoleSearchBo> getList(AdminRolePara adminRolePara) {
        Result<AdminRoleSearchBo> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(adminRolePara);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        AdminRoleSearchBo modelResult = new AdminRoleSearchBo();
        long count = adminRoleDao.getListCount(adminRolePara);
        modelResult.setTotal(count);
        List<AdminRoleSearchModel> modelList = adminRoleDao.getList(adminRolePara);
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    private AdminRole getAdminRole(AdminRoleModel adminRoleModel, boolean mod){
        AdminRole adminRole = new AdminRole();
        if (mod){
            adminRole.setId(adminRoleModel.getId());
        }
        adminRole.setSystemId(adminRoleModel.getSystemId());
        adminRole.setName(adminRoleModel.getName());
        adminRole.setDes(adminRoleModel.getDes());
        return adminRole;
    }

    @Transactional
    @Override
    public ErrorMessage add(AdminRoleModel adminRoleModel) {
        try {
            ValidUtils.validNotNullEx(adminRoleModel, "systemId,name");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        AdminRole adminRole = getAdminRole(adminRoleModel, false);
        int operRes = adminRoleDao.insert(adminRole);
        if(operRes > 0){
            if (adminRoleModel.getMenus() != null){
                addRoleMenus(adminRoleModel, adminRole);
            }
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    private void addRoleMenus(AdminRoleModel adminRoleModel, AdminRole adminRole) {
        for (Integer menuId : adminRoleModel.getMenus()){
            AdminRoleMenu adminRoleMenu = new AdminRoleMenu();
            adminRoleMenu.setRoleId(adminRole.getId());
            adminRoleMenu.setMenuId(menuId);
            adminRoleMenuDao.insert(adminRoleMenu);
        }
    }

    @Transactional
    @Override
    public ErrorMessage mod(AdminRoleModel adminRoleModel) {
        try {
            ValidUtils.validNotNullEx(adminRoleModel, "id,systemId,name");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        AdminRole adminRole = getAdminRole(adminRoleModel, true);
        int operRes = adminRoleDao.update(adminRole);
        if(operRes > 0){
            adminRoleMenuDao.deleteByRoleId(adminRole.getId());
            if (adminRoleModel.getMenus() != null){
                addRoleMenus(adminRoleModel, adminRole);
            }
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Transactional
    @Override
    public ErrorMessage del(AdminRolePara adminRolePara) {
        try{
            ValidUtils.validNotNullEx(adminRolePara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = adminRoleDao.delete(adminRolePara.getId());
        if(operRes > 0){
            adminRoleMenuDao.deleteByRoleId(adminRolePara.getId());
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public Result<AdminRoleInfoBo> getRole(AdminRolePara adminRolePara) {
        Result<AdminRoleInfoBo> modelResult = new Result<>();
        try{
            ValidUtils.validNotNullEx(adminRolePara, "id");
        } catch (Exception ex){
            modelResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            modelResult.setMsg(ex.getMessage());
            return modelResult;
        }
        AdminRoleInfoBo adminRoleInfoBo = new AdminRoleInfoBo();
        AdminRole adminRole = adminRoleDao.getById(adminRolePara.getId());
        if (adminRole != null){
            adminRoleInfoBo.setId(adminRole.getId());
            adminRoleInfoBo.setSystemId(adminRole.getSystemId());
            adminRoleInfoBo.setName(adminRole.getName());
            adminRoleInfoBo.setDes(adminRole.getDes());
            List<Integer> roleMenuIdAll = new ArrayList<>();
            List<AdminRoleMenu> roleMenuList = adminRoleMenuDao.getListByRoleId(adminRole.getId());
            for (AdminRoleMenu rm : roleMenuList){
                roleMenuIdAll.add(rm.getMenuId());
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
                    menuList.add(rightMenuTree);
                }
            }
            // 为一级菜单设置子菜单，getChild是递归调用的
            for (RightMenuTree menu : menuList) {
                menu.setChildren(getChild(menu.getId(), rootMenu));
            }
            adminRoleInfoBo.setMenus(menuList);
            modelResult.setCode(ErrorCode.SUCCESS.getCode());
            modelResult.setMsg(ErrorCode.SUCCESS.getResult());
            modelResult.setData(adminRoleInfoBo);
        }else {
            modelResult.setCode(ErrorCode.USER_NOT_EXIST.getCode());
            modelResult.setMsg(ErrorCode.USER_NOT_EXIST.getResult());
        }
        return modelResult;
    }

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
}
