package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommPointReadBlockPara;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommPointReadBlockService {
    WXResult.Base getPointReadBlockAndroid(CommPointReadBlockPara commPointReadBlockPara);
    WXResult.Base getPointReadBlockMiniProg(CommPointReadBlockPara commPointReadBlockPara, TokenInfoWrap userToken);
}
