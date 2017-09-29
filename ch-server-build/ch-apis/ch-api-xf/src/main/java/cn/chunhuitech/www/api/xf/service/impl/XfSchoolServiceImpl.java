package cn.chunhuitech.www.api.xf.service.impl;

import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.api.xf.model.XfSchoolModelResult;
import cn.chunhuitech.www.core.xf.dao.XfSchoolDao;
import cn.chunhuitech.www.core.xf.model.cus.XfSchoolPara;
import cn.chunhuitech.www.api.xf.service.XfSchoolService;
import cn.chunhuitech.www.core.xf.model.pojo.XfSchool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
@Service
public class XfSchoolServiceImpl implements XfSchoolService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private XfSchoolDao xfSchoolDao;

    @Override
    public Result<XfSchoolModelResult> getList(XfSchoolPara xfSchoolPara) {
        Result<XfSchoolModelResult> retResult = new Result<>();
        try {
            ValidUtils.validNotNull(xfSchoolPara);
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        XfSchoolModelResult xfSchoolModelResult = new XfSchoolModelResult();
        long count = xfSchoolDao.getListCount(xfSchoolPara);
        xfSchoolModelResult.setTotal(count);
        List<XfSchool> xfSchoolList = xfSchoolDao.getList(xfSchoolPara);
        xfSchoolModelResult.setDataList(xfSchoolList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(xfSchoolModelResult);
        return retResult;
    }
}
