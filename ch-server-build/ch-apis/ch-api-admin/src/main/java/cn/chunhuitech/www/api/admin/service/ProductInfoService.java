package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.ProductActivitySearchBo;
import cn.chunhuitech.www.api.admin.model.ProductInfoBo;
import cn.chunhuitech.www.api.admin.model.ProductInfoSearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.ProductActivityPara;
import cn.chunhuitech.www.core.admin.model.cus.ProductInfoPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface ProductInfoService {
    Result<ProductInfoBo> versionCheck(ProductInfo productInfo);

    Result<ProductInfoSearchBo> getList(ProductInfoPara productInfoPara);
    ErrorMessage mod(ProductInfoPara productInfoPara);
    ErrorMessage add(ProductInfoPara productInfoPara);
}
