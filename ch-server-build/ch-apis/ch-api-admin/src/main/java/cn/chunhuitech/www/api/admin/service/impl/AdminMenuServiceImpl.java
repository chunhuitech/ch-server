package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.AdminMenuSearchBo;
import cn.chunhuitech.www.api.admin.model.AdminRoleSearchBo;
import cn.chunhuitech.www.api.admin.service.AdminMenuService;
import cn.chunhuitech.www.api.admin.service.AdminRoleService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminMenuDao;
import cn.chunhuitech.www.core.admin.dao.AdminRoleDao;
import cn.chunhuitech.www.core.admin.dao.AdminRoleMenuDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminMenuPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminMenuSearchModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminMenu;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("all")
/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminMenuDao adminMenuDao;
    @Autowired
    private AdminRoleMenuDao adminRoleMenuDao;

    @Override
    public Result<AdminMenuSearchBo> getList(AdminMenuPara adminMenuPara) {
        Result<AdminMenuSearchBo> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(adminMenuPara);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        AdminMenuSearchBo modelResult = new AdminMenuSearchBo();
        long count = adminMenuDao.getListCount(adminMenuPara);
        modelResult.setTotal(count);
        List<AdminMenuSearchModel> modelList = adminMenuDao.getList(adminMenuPara);
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    @Override
    public ErrorMessage add(AdminMenu adminMenu) {
        try {
            ValidUtils.validNotNullEx(adminMenu, "systemId,name,parentId,resUrl,seq");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        adminMenu.setPath("");
        adminMenu.setStatus(ConstantApi.STATUS_OK);
        adminMenu.setCreateTime(System.currentTimeMillis());
        adminMenu.setModifyTime(System.currentTimeMillis());
        int operRes = adminMenuDao.insert(adminMenu);
        if(operRes > 0){
            adminMenu.setPath("/"+adminMenu.getId());
            adminMenuDao.update(adminMenu);
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage mod(AdminMenu adminMenu) {
        try {
            ValidUtils.validNotNullEx(adminMenu, "id");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        adminMenu.setModifyTime(System.currentTimeMillis());
        int operRes = adminMenuDao.update(adminMenu);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage del(AdminMenuPara adminMenuPara) {
        try{
            ValidUtils.validNotNullEx(adminMenuPara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        boolean exist = adminRoleMenuDao.exist(adminMenuPara.getId());
        if (exist){
            return ErrorCode.DB_ERROR_OCCUPIED;
        }
        int operRes = adminMenuDao.delete(adminMenuPara.getId());
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public Result<AdminMenu> getModel(AdminMenuPara adminMenuPara) {
        return null;
    }
}
