package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.ProductActivitySearchBo;
import cn.chunhuitech.www.api.admin.model.ProductInfoBo;
import cn.chunhuitech.www.api.admin.model.ProductInfoSearchBo;
import cn.chunhuitech.www.api.admin.service.ProductInfoService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.ProductInfoDao;
import cn.chunhuitech.www.core.admin.model.cus.ProductInfoPara;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public Result<ProductInfoSearchBo> getList(ProductInfoPara productInfoPara) {
        Result<ProductInfoSearchBo> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(productInfoPara);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        ProductInfoSearchBo modelResult = new ProductInfoSearchBo();
        long count = productInfoDao.getListCount(productInfoPara);
        modelResult.setTotal(count);
        List<ProductInfo> modelList = productInfoDao.getList(productInfoPara);
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    @Override
    public ErrorMessage mod(ProductInfoPara productInfoPara) {
        try {
            ValidUtils.validNotNullEx(productInfoPara, "id,name,technologyPlatform,version,versionNum");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(productInfoPara.getId().longValue());
        productInfo.setName(productInfoPara.getName());
        productInfo.setTechnologyPlatform(productInfoPara.getTechnologyPlatform());
        productInfo.setVersion(productInfoPara.getVersion());
        productInfo.setVersionNum(productInfoPara.getVersionNum());
        productInfo.setDownAddress(productInfoPara.getDownAddress());
        productInfo.setRemarks(productInfoPara.getRemarks());
        productInfo.setModifyTime(System.currentTimeMillis());
        int operRes = productInfoDao.updateByUp(productInfo);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else
        {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage add(ProductInfoPara productInfoPara) {
        try {
            ValidUtils.validNotNullEx(productInfoPara, "name,technologyPlatform,version,versionNum");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        ProductInfo productInfo = new ProductInfo();
        productInfo.setName(productInfoPara.getName());
        productInfo.setTechnologyPlatform(productInfoPara.getTechnologyPlatform());
        productInfo.setVersion(productInfoPara.getVersion());
        productInfo.setVersionNum(productInfoPara.getVersionNum());
        productInfo.setDownAddress(productInfoPara.getDownAddress());
        productInfo.setRemarks(productInfoPara.getRemarks());
        productInfo.setStatus(ConstantApi.STATUS_OK);
        productInfo.setCreateTime(System.currentTimeMillis());
        productInfo.setModifyTime(System.currentTimeMillis());
        int operRes = productInfoDao.insert(productInfo);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }
}
