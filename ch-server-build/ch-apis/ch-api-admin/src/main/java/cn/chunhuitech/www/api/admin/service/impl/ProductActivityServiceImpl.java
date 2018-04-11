package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.constant.Constant;
import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.ProductActivityDao;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class ProductActivityServiceImpl implements ProductActivityService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductActivityDao productActivityDao;

    @Override
    public ErrorMessage report(ProductActivity productActivity) {
        try {
            ValidUtils.validNotNullEx(productActivity, "clientFlag");
        } catch (Exception ex) {
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        productActivity.setStatus(ConstantApi.STATUS_OK);
        Long Id = productActivityDao.existClient(productActivity);
        if (Id == null){
            productActivityDao.insert(productActivity);
        } else {
            productActivity.setId(Id);
            productActivityDao.update(productActivity);
        }
        return ErrorCode.SUCCESS;
    }
}
