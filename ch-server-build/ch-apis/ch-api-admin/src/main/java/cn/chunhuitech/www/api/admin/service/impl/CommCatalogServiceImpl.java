package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommCatalogBo;
import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.common.model.*;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.dao.CommCatalogDao;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommCatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class CommCatalogServiceImpl implements CommCatalogService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommCatalogDao commCatalogDao;

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public Result<CommCatalogBo> fetchCatalog(CommCatalogPara commCatalogPara) {
        try {
            ValidUtils.validNotNullEx(commCatalogPara, "classId");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        CommCatalogBo modelResult = new CommCatalogBo();
        List<CommCatalog> modelList = commCatalogDao.fetchCatalog(commCatalogPara);
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

    @Override
    public WXResult.Base getCatalogAndorid(CommCatalogPara commCatalogPara) {
       return getCatalog(commCatalogPara);
    }

    @Override
    public WXResult.Base getCatalogMiniProg(CommCatalogPara commCatalogPara, TokenInfoWrap userToken) {
        //验证登录用户
        if(!adminUserDao.verifyUser(userToken.getId(), userToken.getUsername())){
            return WXErrorCode.LOGIN_PARAM_TOKEN_ERROR;
        }
        return getCatalog(commCatalogPara);
    }

    private WXResult.Base getCatalog(CommCatalogPara commCatalogPara) {
        try {
            ValidUtils.validNotNullEx(commCatalogPara, "classId");
        } catch (Exception ex) {
            return new WXResult.Error(WXErrorCode.ARGUMENT_INVALID.getCode(), ex.getMessage());
        }
        CommCatalogBo modelResult = new CommCatalogBo();
        List<CommCatalog> modelList = commCatalogDao.fetchCatalog(commCatalogPara);
        modelResult.setDataList(modelList);
        return new WXResult.Success<>(modelResult);
    }

}
