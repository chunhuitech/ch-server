package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommCatalogBo;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommCatalogService {
    Result<CommCatalogBo> fetchCatalog(CommCatalogPara commCatalogPara);
    WXResult.Base getCatalog(CommCatalogPara commCatalogPara, TokenInfoWrap userToken);
}
