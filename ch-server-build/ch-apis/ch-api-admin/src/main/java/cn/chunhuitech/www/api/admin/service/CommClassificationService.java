package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommClassificationService {
    Result<CommClassificationBo> fetchClass(CommClassificationPara commClassificationPara);
    Result<CommClassificationBo> fetchChildren(CommClassificationPara commClassificationPara);
    WXResult.Base  getChildren(CommClassificationPara commClassificationPara, TokenInfoWrap userToken);

}
