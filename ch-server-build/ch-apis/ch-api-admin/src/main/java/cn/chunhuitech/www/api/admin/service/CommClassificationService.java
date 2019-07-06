package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommClassificationService {
    Result<CommClassificationBo> fetchClass(CommClassificationPara commClassificationPara, Byte showFlag, Integer classDataType);
    Result<CommClassificationBo> fetchChildren(CommClassificationPara commClassificationPara, Byte showFlag, Integer classDataType);
    Result<CommClassificationBo> fetchAll(Byte showFlag, Integer classDataType);
    ErrorMessage add(CommClassification commClassification);
    ErrorMessage mod(CommClassification commClassification);
    ErrorMessage del(CommClassificationPara commClassificationPara);
    Result<CommClassification>  getModel(CommClassificationPara commClassificationPara);
    WXResult.Base  getChildrenAndroid(CommClassificationPara commClassificationPara);
    WXResult.Base  getChildrenMiniProg(CommClassificationPara commClassificationPara, TokenInfoWrap userToken);

}
