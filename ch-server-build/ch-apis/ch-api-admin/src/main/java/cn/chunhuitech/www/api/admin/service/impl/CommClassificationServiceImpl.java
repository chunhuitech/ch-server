package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.*;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.dao.CommClassificationDao;
import cn.chunhuitech.www.core.admin.dao.CommRecordDao;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class CommClassificationServiceImpl implements CommClassificationService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommClassificationDao commClassificationDao;

    @Autowired
    private CommRecordDao commRecordDao;

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public Result<CommClassificationBo> fetchClass(CommClassificationPara commClassificationPara) {
        try {
            ValidUtils.validNotNullEx(commClassificationPara, "syncTime");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        long lastModifyTime = commClassificationDao.getLastModifyTime();
        if (commClassificationPara.getSyncTime() >= lastModifyTime) {
            return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getResult(), null);
        }
        CommClassificationBo modelResult = new CommClassificationBo();
        List<CommClassification> modelList = commClassificationDao.fetchClass(commClassificationPara);
        modelResult.setDataList(modelList);
        long maxTime = 0;
        for (CommClassification commClassification : modelList) {
            maxTime = maxTime >= commClassification.getModifyTime() ? maxTime : commClassification.getModifyTime();
        }
        modelResult.setLastModTime(maxTime);
        return new Result<>(modelResult);
    }

    @Override
    public Result<CommClassificationBo> fetchChildren(CommClassificationPara commClassificationPara) {
        try {
            ValidUtils.validNotNullEx(commClassificationPara, "parentId");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        CommClassificationBo modelResult = new CommClassificationBo();
        List<CommClassification> modelList = commClassificationDao.fetchChildren(commClassificationPara);
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

    @Override
    public Result<CommClassificationBo> fetchAll() {
        CommClassificationBo modelResult = new CommClassificationBo();
        List<CommClassification> modelList = commClassificationDao.fetchAll();
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

    @Override
    public ErrorMessage add(CommClassification commClassification) {
        try {
            ValidUtils.validNotNullEx(commClassification, "cnName,enName,parentId,leaf,sortNum,des");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        commClassification.setStatus(ConstantApi.STATUS_OK);
        commClassification.setCreateTime(System.currentTimeMillis());
        commClassification.setModifyTime(System.currentTimeMillis());
        int operRes = commClassificationDao.insert(commClassification);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage mod(CommClassification commClassification) {
        try {
            ValidUtils.validNotNullEx(commClassification, "id,cnName,enName,parentId,leaf,sortNum,des");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        commClassification.setModifyTime(System.currentTimeMillis());
        int operRes = commClassificationDao.update(commClassification);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage del(CommClassificationPara commClassificationPara) {
        try{
            ValidUtils.validNotNullEx(commClassificationPara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        CommRecordPara commRecordPara = new CommRecordPara();
        commRecordPara.setPage(1);
        commRecordPara.setClassId(commClassificationPara.getId());
        commRecordPara.setLimit(2);
        long count = commRecordDao.getListCount(commRecordPara);
        if (count > 0){
            return ErrorCode.RECORD_HAS_SUBDATA;
        }
        int operRes = commClassificationDao.delete(commClassificationPara.getId());
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public Result<CommClassification> getModel(CommClassificationPara commClassificationPara) {
        Result<CommClassification> modelResult = new Result<>();
        try{
            ValidUtils.validNotNullEx(commClassificationPara, "id");
        } catch (Exception ex){
            modelResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            modelResult.setMsg(ex.getMessage());
            return modelResult;
        }
        CommClassification commClassification = commClassificationDao.getById(commClassificationPara.getId());
        modelResult.setCode(ErrorCode.SUCCESS.getCode());
        modelResult.setMsg(ErrorCode.SUCCESS.getResult());
        modelResult.setData(commClassification);
        return modelResult;
    }

    @Override
    public WXResult.Base getChildrenAndroid(CommClassificationPara commClassificationPara) {
        return getChildren(commClassificationPara);
    }

    @Override
    public WXResult.Base getChildrenMiniProg(CommClassificationPara commClassificationPara, TokenInfoWrap userToken) {
        //验证登录用户
        if(!adminUserDao.verifyUser(userToken.getId(), userToken.getUsername())){
            return WXErrorCode.LOGIN_PARAM_TOKEN_ERROR;
        }
        return getChildren(commClassificationPara);
    }

    private WXResult.Base getChildren(CommClassificationPara commClassificationPara) {
        try {
            ValidUtils.validNotNullEx(commClassificationPara, "parentId");
        } catch (Exception ex) {
            return new WXResult.Error(WXErrorCode.ARGUMENT_INVALID.getCode(), ex.getMessage());
        }
        CommClassificationBo modelResult = new CommClassificationBo();
        List<CommClassification> modelList = commClassificationDao.fetchChildren(commClassificationPara);
        modelResult.setDataList(modelList);
        return new WXResult.Success<>(modelResult);
    }
}
