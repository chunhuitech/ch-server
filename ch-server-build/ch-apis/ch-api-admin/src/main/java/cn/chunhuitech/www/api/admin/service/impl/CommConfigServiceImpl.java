package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.model.CommConfigBo;
import cn.chunhuitech.www.api.admin.model.CommRecordBo;
import cn.chunhuitech.www.api.admin.service.CommConfigService;
import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.CommConfigDao;
import cn.chunhuitech.www.core.admin.dao.CommRecordDao;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
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
public class CommConfigServiceImpl implements CommConfigService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommConfigDao commConfigDao;

    @Override
    public Result<CommConfigBo> getRecordDataVersion() {
        CommConfigBo modelResult = new CommConfigBo();
        Integer recordDataVersion = commConfigDao.getRecordDataVersion("recordDataVersion");
        modelResult.setRecordDataVersion(recordDataVersion);
        String recordDataDownAddr = commConfigDao.getRecordDataDownAddr("recordDataDownAddr");
        modelResult.setRecordDataDownAddr(recordDataDownAddr);
        return new Result<>(modelResult);
    }
}
