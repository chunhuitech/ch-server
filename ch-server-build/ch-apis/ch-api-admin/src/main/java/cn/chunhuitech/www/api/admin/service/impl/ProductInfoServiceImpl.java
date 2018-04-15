package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.ProductInfoBo;
import cn.chunhuitech.www.api.admin.service.ProductInfoService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.ProductInfoDao;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public Result<ProductInfoBo> versionCheck(ProductInfo productInfo) {
        try {
            ValidUtils.validNotNullEx(productInfo, "name,technologyPlatform");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        ProductInfo productInfo2 = productInfoDao.getNumVersion(productInfo.getName(), productInfo.getTechnologyPlatform());
        ProductInfoBo productInfoBo = new ProductInfoBo();
        productInfoBo.setDownAddress(productInfo2.getDownAddress());
        productInfoBo.setVersion(productInfo2.getVersion());
        productInfoBo.setVersionNum(productInfo2.getVersionNum());
        return new Result<>(productInfoBo);
    }
}
