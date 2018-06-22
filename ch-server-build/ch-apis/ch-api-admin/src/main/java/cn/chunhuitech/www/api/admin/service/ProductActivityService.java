package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.ProductActivitySearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.ProductActivityPara;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface ProductActivityService {
    ErrorMessage report(ProductActivity productActivity);
    WXResult.Base reportbyWx(ProductActivity productActivity);

    Result<ProductActivitySearchBo> getList(ProductActivityPara productActivityPara);
}
