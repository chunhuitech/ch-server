package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommPointReadBlockBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommPointReadBlockPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommPointReadBlockService {
    WXResult.Base getPointReadBlockAndroid(CommPointReadBlockPara commPointReadBlockPara);
    WXResult.Base getPointReadBlockMiniProg(CommPointReadBlockPara commPointReadBlockPara, TokenInfoWrap userToken);
    WXResult.Base getPointReadBlock(CommPointReadBlockPara commPointReadBlockPara);
    Result<CommPointReadBlockBo> fetchPointReadBlock(CommPointReadBlockPara commPointReadBlockPara);
    ErrorMessage add(CommPointReadBlock commPointReadBlock);
    ErrorMessage mod(CommPointReadBlock commPointReadBlock);
    ErrorMessage del(CommPointReadBlockPara commPointReadBlockPara);
    Result<CommPointReadBlock> getModel(CommPointReadBlockPara commPointReadBlockPara);
}
