package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommCatalogBo;
import cn.chunhuitech.www.api.admin.model.CommPointReadBlockBo;
import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.admin.service.CommPointReadBlockService;
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

    private WXResult.Base getPointReadBlock(CommPointReadBlockPara commPointReadBlockPara) {
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
}
