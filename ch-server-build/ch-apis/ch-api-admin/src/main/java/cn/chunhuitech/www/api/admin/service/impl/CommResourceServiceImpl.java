package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommCatalogBo;
import cn.chunhuitech.www.api.admin.model.CommResourceBo;
import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.admin.service.CommResourceService;
import cn.chunhuitech.www.api.common.model.*;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.dao.CommCatalogDao;
import cn.chunhuitech.www.core.admin.dao.CommResourceDao;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommCatalog;
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
    public WXResult.Base getResource(CommClassificationPara commClassificationPara, TokenInfoWrap userToken) {
        //验证登录用户
        if(!adminUserDao.verifyUser(userToken.getId(), userToken.getUsername())){
            return WXErrorCode.LOGIN_PARAM_TOKEN_ERROR;
        }
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
