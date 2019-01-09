package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommResourceBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.cus.CommResourcePara;
import cn.chunhuitech.www.core.admin.model.pojo.CommResource;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommResourceService {
    Result<CommResourceBo> fetchResource(CommClassificationPara commClassificationPara);
    ErrorMessage add(CommResource commResource);
    ErrorMessage mod(CommResource commResource);
    ErrorMessage del(CommResourcePara commResourcePara);
    Result<CommResource>  getModel(CommResourcePara commResourcePara);

    WXResult.Base getResourceAndroid(CommClassificationPara commClassificationPara);
    WXResult.Base getResourceMiniProg(CommClassificationPara commClassificationPara, TokenInfoWrap userToken);
}
