package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.ProductInfoBo;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface ProductInfoService {
    Result<ProductInfoBo> versionCheck(ProductInfo productInfo);
}
