package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.model.CommRecordBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.dao.CommClassificationDao;
import cn.chunhuitech.www.core.admin.dao.CommRecordDao;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class CommRecordServiceImpl implements CommRecordService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommRecordDao commRecordDao;

    @Override
    public Result<CommRecordBo> fetchRecord(CommRecordPara commRecordPara) {
//        try {
//            ValidUtils.validNotNull(commRecordPara);
//        } catch (Exception ex) {
//            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
//        }
        CommRecordBo modelResult = new CommRecordBo();
        List<CommRecord> modelList = commRecordDao.fetchRecord(commRecordPara);
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

}
