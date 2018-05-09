package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommResourceBo;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommResourceService {
    Result<CommResourceBo> fetchResource(CommClassificationPara commClassificationPara);
}
