package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.ProductActivitySearchBo;
import cn.chunhuitech.www.api.admin.model.ProductInfoSearchBo;
import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminUserDao;
import cn.chunhuitech.www.core.admin.dao.ProductActivityDao;
import cn.chunhuitech.www.core.admin.dao.ProductInfoDao;
import cn.chunhuitech.www.core.admin.model.cus.ProductActivityPara;
import cn.chunhuitech.www.core.admin.model.cus.ProductInfoPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;
import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by hechengjin on 17-9-29.
 */
@SuppressWarnings("all")
@Service
public class ProductActivityServiceImpl implements ProductActivityService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductActivityDao productActivityDao;
    @Autowired
    private ProductInfoDao productInfoDao;
    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public ErrorMessage report(ProductActivity productActivity) {
        if (productActivity.getClientFlag() == null){
            AdminUser adminUser =adminUserDao.getById(productActivity.getUserId().intValue());
            productActivity.setClientFlag(adminUser.getOpenId());
        }
        try {
            ValidUtils.validNotNullEx(productActivity, "clientFlag");
        } catch (Exception ex) {
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        productActivity.setStatus(ConstantApi.STATUS_OK);
        long curTime = System.currentTimeMillis();
        ProductActivity product = productActivityDao.existClient(productActivity);
        if (product == null){
            productActivity.setCreateTime(curTime);
            productActivity.setModifyTime(curTime);
            productActivity.setEventCount(1);
            productActivityDao.insert(productActivity);
        } else {
            //productActivity.setId(product.getId());
            product.setModifyTime(curTime);
            product.setEventCount(product.getEventCount() + 1);
            //productActivity.setRemarks(product.getRemarks());
            productActivityDao.updateByUp(product);
        }
        return ErrorCode.SUCCESS;
    }

    @Override
    public WXResult.Base reportbyWx(ProductActivity productActivity) {
        return new WXResult.Success<>(report(productActivity));
    }

    @Override
    public Result<ProductActivitySearchBo> getList(ProductActivityPara productActivityPara) {
        Result<ProductActivitySearchBo> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(productActivityPara);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        ProductActivitySearchBo modelResult = new ProductActivitySearchBo();
        long count = productActivityDao.getListCount(productActivityPara);
        modelResult.setTotal(count);
        List<ProductActivity> modelList = productActivityDao.getList(productActivityPara);
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    @Override
    public Result<ProductInfoSearchBo> getProductInfoList() {
        Result<ProductInfoSearchBo> retResult = new Result<>();

        ProductInfoSearchBo modelResult = new ProductInfoSearchBo();
        ProductInfoPara productInfoPara = new ProductInfoPara();
        productInfoPara.setPage(1);
        productInfoPara.setLimit(100);
        long count = productInfoDao.getListCount(productInfoPara);
        modelResult.setTotal(count);
        List<ProductInfo> modelList = productInfoDao.getList(productInfoPara);
        for (ProductInfo item : modelList) {
            item.setName(item.getName() + "(" +item.getTechnologyPlatform() + "," + item.getVersion() + ")");
        }
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    @Override
    public ErrorMessage mod(ProductActivityPara productActivityPara) {
        try {
            ValidUtils.validNotNullEx(productActivityPara, "id,remarks");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        ProductActivity productActivity = new ProductActivity();
        productActivity.setId(productActivityPara.getId().longValue());
        productActivity.setRemarks(productActivityPara.getRemarks());
        productActivity.setModifyTime(System.currentTimeMillis());
        int operRes = productActivityDao.updateByUp(productActivity);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else
        {
            return ErrorCode.DB_ERROR;
        }
    }
}
