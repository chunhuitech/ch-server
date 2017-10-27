package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.AdminSystemSearchBo;
import cn.chunhuitech.www.api.admin.service.AdminSystemService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminSystemDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminSystemPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class AdminSystemServiceImpl implements AdminSystemService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminSystemDao adminSystemDao;

    @Override
    public Result<AdminSystemSearchBo> getList(AdminSystemPara adminSystemPara) {
        Result<AdminSystemSearchBo> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(adminSystemPara);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        AdminSystemSearchBo modelResult = new AdminSystemSearchBo();
        long count = adminSystemDao.getListCount(adminSystemPara);
        modelResult.setTotal(count);
        List<AdminSystem> modelList = adminSystemDao.getList(adminSystemPara);
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    @Override
    public ErrorMessage add(AdminSystem adminSystem) {
        try {
            ValidUtils.validNotNullEx(adminSystem, "name");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = adminSystemDao.insert(adminSystem);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage mod(AdminSystem adminSystem) {
        try {
            ValidUtils.validNotNullEx(adminSystem, "id,name");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = adminSystemDao.update(adminSystem);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage del(AdminSystemPara adminSystemPara) {
        try{
            ValidUtils.validNotNullEx(adminSystemPara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = adminSystemDao.delete(adminSystemPara.getId());
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

}
