package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommResourceBo;
import cn.chunhuitech.www.api.admin.service.CommResourceService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.*;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.dao.CommPointReadBlockDao;
import cn.chunhuitech.www.core.admin.dao.CommResourceDao;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.cus.CommResourcePara;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
import cn.chunhuitech.www.core.admin.model.pojo.CommResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class CommResourceServiceImpl implements CommResourceService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommResourceDao commResourceDao;

    @Autowired
    private AdminUserDao adminUserDao;

    @Autowired
    private CommPointReadBlockDao commPointReadBlockDao;


    @Override
    public Result<CommResourceBo> fetchResource(CommClassificationPara commClassificationPara) {
        try {
            ValidUtils.validNotNullEx(commClassificationPara, "id");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        CommResourceBo modelResult = new CommResourceBo();
        List<CommResource> modelList = commResourceDao.fetchResource(commClassificationPara);
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

    @Override
    public ErrorMessage add(CommResource commResource) {
        try {
            ValidUtils.validNotNullEx(commResource, "classId,sortNum,title,label,relativePath,fileSize,fileType");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        commResource.setStatus(ConstantApi.STATUS_OK);
        commResource.setCreateTime(System.currentTimeMillis());
        commResource.setModifyTime(System.currentTimeMillis());
        int operRes = commResourceDao.insert(commResource);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage mod(CommResource commResource) {
        try {
            ValidUtils.validNotNullEx(commResource, "id");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        commResource.setModifyTime(System.currentTimeMillis());
        int operRes = commResourceDao.update(commResource);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage del(CommResourcePara commResourcePara) {
        try{
            ValidUtils.validNotNullEx(commResourcePara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        List<CommPointReadBlock>  blockList = commPointReadBlockDao.fetchPointBlockByResourceId(commResourcePara.getId());
        if (blockList.size() > 0){
            return ErrorCode.RECORD_HAS_SUBDATA;
        }
        int operRes = commResourceDao.delete(commResourcePara.getId());
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public Result<CommResource> getModel(CommResourcePara commResourcePara) {
        Result<CommResource> modelResult = new Result<>();
        try{
            ValidUtils.validNotNullEx(commResourcePara, "id");
        } catch (Exception ex){
            modelResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            modelResult.setMsg(ex.getMessage());
            return modelResult;
        }
        CommResource commResource = commResourceDao.getById(commResourcePara.getId());
        modelResult.setCode(ErrorCode.SUCCESS.getCode());
        modelResult.setMsg(ErrorCode.SUCCESS.getResult());
        modelResult.setData(commResource);
        return modelResult;
    }

    @Override
    public WXResult.Base getResourceAndroid(CommClassificationPara commClassificationPara) {
        return getResource(commClassificationPara);
    }

    @Override
    public WXResult.Base getResourceMiniProg(CommClassificationPara commClassificationPara, TokenInfoWrap userToken) {
        //验证登录用户
        if(!adminUserDao.verifyUser(userToken.getId(), userToken.getUsername())){
            return WXErrorCode.LOGIN_PARAM_TOKEN_ERROR;
        }
        return getResource(commClassificationPara);
    }

    private WXResult.Base getResource(CommClassificationPara commClassificationPara) {
        try {
            ValidUtils.validNotNullEx(commClassificationPara, "id");
        } catch (Exception ex) {
            return new WXResult.Error(WXErrorCode.ARGUMENT_INVALID.getCode(), ex.getMessage());
        }
        CommResourceBo modelResult = new CommResourceBo();
        List<CommResource> modelList = commResourceDao.fetchResource(commClassificationPara);
        modelResult.setDataList(modelList);
        return new WXResult.Success<>(modelResult);
    }

}
