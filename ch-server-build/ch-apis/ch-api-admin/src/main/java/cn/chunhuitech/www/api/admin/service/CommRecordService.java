package cn.chunhuitech.www.api.admin.service;

import cn.chunhuitech.www.api.admin.model.CommRecordBo;
import cn.chunhuitech.www.api.admin.model.CommRecordPagesBo;
import cn.chunhuitech.www.api.admin.model.CommRecordSearchBo;
import cn.chunhuitech.www.api.admin.model.CommRecordWebSearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface CommRecordService {
    Result<CommRecordBo> fetchRecord(CommRecordPara commRecordPara);
    Result<CommRecordPagesBo> fetchPageInfo(CommRecordPara commRecordPara);

    ErrorMessage addPage(CommRecordPageModel commRecordPageModel);
    ErrorMessage modPage(CommRecordPageModel commRecordPageModel);

    Result<CommRecordSearchBo> getList(CommRecordPara commRecordPara);
    Result<CommRecordWebSearchBo> getList2(CommRecordPara commRecordPara);
    ErrorMessage add(CommRecord commRecord);
    ErrorMessage mod(CommRecord commRecord);
    ErrorMessage del(CommRecordPara commRecordPara);

    WXResult.Base getPageListAndroid(CommRecordPara commRecordPara);
    WXResult.Base getPageListMiniProg(CommRecordPara commRecordPara, TokenInfoWrap userToken);
}
