package cn.chunhuitech.www.api.xf.service;

import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.xf.model.XfSchoolModelResult;
import cn.chunhuitech.www.core.xf.model.cus.XfSchoolPara;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface XfSchoolService {
    Result<XfSchoolModelResult> getList(XfSchoolPara xfSchoolPara);
}
