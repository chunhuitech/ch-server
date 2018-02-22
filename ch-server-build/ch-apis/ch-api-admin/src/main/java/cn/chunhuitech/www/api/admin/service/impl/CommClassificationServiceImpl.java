package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.AdminRoleSearchBo;
import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.service.AdminRoleService;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.AdminRoleDao;
import cn.chunhuitech.www.core.admin.dao.CommClassificationDao;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class CommClassificationServiceImpl implements CommClassificationService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommClassificationDao commClassificationDao;

    @Override
    public Result<CommClassificationBo> fetchClass(CommClassificationPara commClassificationPara) {
//        try {
//            ValidUtils.validNotNull(commClassificationPara);
//        } catch (Exception ex) {
//            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
//        }
        CommClassificationBo modelResult = new CommClassificationBo();
        List<CommClassification> modelList = commClassificationDao.fetchClass(commClassificationPara);
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

}
