package cn.chunhuitech.www.api.admin.service.impl;

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
    public Result<Integer> versionCheck(ProductInfo productInfo) {
        try {
            ValidUtils.validNotNullEx(productInfo, "name");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        Integer numVersion = productInfoDao.getNumVersion(productInfo.getName());
        return new Result<>(numVersion);
    }
}
