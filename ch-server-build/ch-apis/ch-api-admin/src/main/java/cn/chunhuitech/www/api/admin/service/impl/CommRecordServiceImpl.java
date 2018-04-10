package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.model.CommRecordBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
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
    private static final Integer MaxRecordCount = 800;

    @Autowired
    private CommRecordDao commRecordDao;

    @Override
    public Result<CommRecordBo> fetchRecord(CommRecordPara commRecordPara) {
        try {
            ValidUtils.validNotNullEx(commRecordPara, "syncTime");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        long lastModifyTime = commRecordDao.getLastModifyTime();
        if (commRecordPara.getSyncTime() >= lastModifyTime) {
            return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getResult(), null);
        }
        CommRecordBo modelResult = new CommRecordBo();
        Integer recCounts = commRecordDao.fetchRecordCount(commRecordPara);
        if (recCounts > MaxRecordCount){
            return new Result<>(ErrorCode.WARN_TOO_MAX_COUNT.getCode(), ErrorCode.WARN_TOO_MAX_COUNT.getResult(), null);
        }
        List<CommRecord> modelList = commRecordDao.fetchRecord(commRecordPara);
        modelResult.setDataList(modelList);
        long maxTime = 0;
        for (CommRecord commRecord : modelList) {
            maxTime = maxTime >= commRecord.getModifyTime() ? maxTime : commRecord.getModifyTime();
        }
        modelResult.setLastModTime(maxTime);
        return new Result<>(modelResult);
    }

}
