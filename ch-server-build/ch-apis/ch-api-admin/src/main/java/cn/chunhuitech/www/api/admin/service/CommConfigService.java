package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommConfigBo;
import cn.chunhuitech.www.api.common.model.Result;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommConfigService {
    Result<CommConfigBo> getRecordDataVersion();
}
