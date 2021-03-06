package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommCatalogBo;
import cn.chunhuitech.www.api.admin.model.CommPointReadBlockBo;
import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.admin.service.CommPointReadBlockService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.*;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.dao.CommCatalogDao;
import cn.chunhuitech.www.core.admin.dao.CommPointReadBlockDao;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.admin.model.cus.CommPointReadBlockPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommCatalog;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class CommPointReadBlockServiceImpl implements CommPointReadBlockService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommPointReadBlockDao commPointReadBlockDao;

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public WXResult.Base getPointReadBlockMiniProg(CommPointReadBlockPara commPointReadBlockPara, TokenInfoWrap userToken) {
        //验证登录用户
        if(!adminUserDao.verifyUser(userToken.getId(), userToken.getUsername())){
            return WXErrorCode.LOGIN_PARAM_TOKEN_ERROR;
        }
        return getPointReadBlock(commPointReadBlockPara);
    }

    @Override
    public WXResult.Base getPointReadBlockAndroid(CommPointReadBlockPara commPointReadBlockPara) {
        return getPointReadBlock(commPointReadBlockPara);
    }

    @Override
    public WXResult.Base getPointReadBlock(CommPointReadBlockPara commPointReadBlockPara) {
        try {
            ValidUtils.validNotNullEx(commPointReadBlockPara, "pageId");
        } catch (Exception ex) {
            return new WXResult.Error(WXErrorCode.ARGUMENT_INVALID.getCode(), ex.getMessage());
        }
        CommPointReadBlockBo modelResult = new CommPointReadBlockBo();
        List<CommPointReadBlock> modelList = commPointReadBlockDao.fetchPointBlock(commPointReadBlockPara);
        modelResult.setDataList(modelList);
        return new WXResult.Success<>(modelResult);
    }

    @Override
    public Result<CommPointReadBlockBo> fetchPointReadBlock(CommPointReadBlockPara commPointReadBlockPara) {
        try {
            ValidUtils.validNotNullEx(commPointReadBlockPara, "pageId");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        CommPointReadBlockBo modelResult = new CommPointReadBlockBo();
        List<CommPointReadBlock> modelList = commPointReadBlockDao.fetchPointBlock(commPointReadBlockPara);
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

    @Override
    public ErrorMessage add(CommPointReadBlock commPointReadBlock) {
        try {
            ValidUtils.validNotNullEx(commPointReadBlock, "recordId,resourceId,sortNum,leftPosition,topPosition,width,height,beginPoint,endPoint,title,text");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        commPointReadBlock.setStatus(ConstantApi.STATUS_OK);
        commPointReadBlock.setCreateTime(System.currentTimeMillis());
        commPointReadBlock.setModifyTime(System.currentTimeMillis());
        int operRes = commPointReadBlockDao.insert(commPointReadBlock);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage mod(CommPointReadBlock commPointReadBlock) {
        try {
            ValidUtils.validNotNullEx(commPointReadBlock, "id,recordId,resourceId,sortNum,leftPosition,topPosition,width,height,beginPoint,endPoint,title,text");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        commPointReadBlock.setModifyTime(System.currentTimeMillis());
        int operRes = commPointReadBlockDao.update(commPointReadBlock);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage del(CommPointReadBlockPara commPointReadBlockPara) {
        try{
            ValidUtils.validNotNullEx(commPointReadBlockPara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = commPointReadBlockDao.delete(commPointReadBlockPara.getId());
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public Result<CommPointReadBlock> getModel(CommPointReadBlockPara commPointReadBlockPara) {
        Result<CommPointReadBlock> modelResult = new Result<>();
        try{
            ValidUtils.validNotNullEx(commPointReadBlockPara, "id");
        } catch (Exception ex){
            modelResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            modelResult.setMsg(ex.getMessage());
            return modelResult;
        }
        CommPointReadBlock commPointReadBlock = commPointReadBlockDao.getById(commPointReadBlockPara.getId());
        modelResult.setCode(ErrorCode.SUCCESS.getCode());
        modelResult.setMsg(ErrorCode.SUCCESS.getResult());
        modelResult.setData(commPointReadBlock);
        return modelResult;
    }
}
