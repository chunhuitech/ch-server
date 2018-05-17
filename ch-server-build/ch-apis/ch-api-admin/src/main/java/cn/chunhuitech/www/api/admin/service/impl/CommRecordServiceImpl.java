package cn.chunhuitech.www.api.admin.service.impl;

import cn.chunhuitech.www.api.admin.constant.Constant;
import cn.chunhuitech.www.api.admin.model.CommRecordBo;
import cn.chunhuitech.www.api.admin.model.CommRecordPagesBo;
import cn.chunhuitech.www.api.admin.model.CommRecordSearchBo;
import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorCode;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.util.ValidUtils;
import cn.chunhuitech.www.core.admin.dao.CommPointReadBlockDao;
import cn.chunhuitech.www.core.admin.dao.CommRecordDao;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageBlockModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private CommPointReadBlockDao commPointReadBlockDao;

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

    @Override
    public Result<CommRecordPagesBo> fetchPageInfo(CommRecordPara commRecordPara) {
        try {
            ValidUtils.validNotNullEx(commRecordPara, "classId,pages");
        } catch (Exception ex) {
            return new Result<>(ErrorCode.ILLEGAL_ARGUMENT.getCode(), ex.getMessage(), null);
        }
        CommRecordPagesBo modelResult = new CommRecordPagesBo();
        Integer recCounts = commRecordDao.fetchRecordPageCount(commRecordPara);
        modelResult.setTotalPage(recCounts);
        List<CommRecordPageBlockModel> modelList = commRecordDao.fetchRecordPage(commRecordPara);
        modelResult.setDataList(modelList);
        return new Result<>(modelResult);
    }

    @Override
    public Result<CommRecordSearchBo> getList(CommRecordPara commRecordPara) {
        Result<CommRecordSearchBo> retResult = new Result<>();
        try {
            ValidUtils.validNotNullEx(commRecordPara, "classId,page,limit");
        } catch (Exception ex) {
            retResult.setCode(ErrorCode.ILLEGAL_ARGUMENT.getCode());
            retResult.setMsg(ex.getMessage());
            logger.error(ex.getMessage());
            return retResult;
        }

        CommRecordSearchBo modelResult = new CommRecordSearchBo();
        long count = commRecordDao.getListCount(commRecordPara);
        modelResult.setTotal(count);
        List<CommRecordSearchModel> modelList = commRecordDao.getList(commRecordPara);
        modelResult.setDataList(modelList);
        retResult.setCode(ErrorCode.SUCCESS.getCode());
        retResult.setMsg(ErrorCode.SUCCESS.getResult());
        retResult.setData(modelResult);
        return retResult;
    }

    private void addPageBlock(CommRecord commRecord, CommRecordPageModel commRecordPageModel){
        if(commRecordPageModel.getBlockList() != null){
            for (CommRecordPageBlockModel commRecordPageBlockModel : commRecordPageModel.getBlockList()){
                CommPointReadBlock commPointReadBlock = new CommPointReadBlock();
                commPointReadBlock.setRecordId(commRecord.getId());

                commPointReadBlock.setResourceId(commRecordPageBlockModel.getUrlId());
                commPointReadBlock.setSortNum(commRecordPageBlockModel.getSortIndex());
                commPointReadBlock.setLeftPosition(commRecordPageBlockModel.getL());
                commPointReadBlock.setTopPosition(commRecordPageBlockModel.getT());
                commPointReadBlock.setWidth(commRecordPageBlockModel.getW());
                commPointReadBlock.setHeight(commRecordPageBlockModel.getH());
                commPointReadBlock.setBeginPoint(commRecordPageBlockModel.getBg());
                commPointReadBlock.setEndPoint(commRecordPageBlockModel.getEd());
                commPointReadBlock.setTitle(commRecordPageBlockModel.getText()); //en
                commPointReadBlock.setText(commRecordPageBlockModel.getText()); //cn
                commPointReadBlock.setStatus(ConstantApi.STATUS_OK);
                commPointReadBlock.setModifyTime(System.currentTimeMillis());
                commPointReadBlock.setCreateTime(System.currentTimeMillis());
                commPointReadBlockDao.insert(commPointReadBlock);
            }
        }
    }

    @Transactional
    @Override
    public ErrorMessage addPage(CommRecordPageModel commRecordPageModel) {
        try {
            ValidUtils.validNotNullEx(commRecordPageModel, "bookId,page,title,imageUrl");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        //添加page
        CommRecord commRecord = getRecord(commRecordPageModel, false);
        commRecordDao.insert(commRecord);
        //添加page block
        addPageBlock(commRecord, commRecordPageModel);
        return ErrorCode.SUCCESS;
    }

    @Override
    public ErrorMessage modPage(CommRecordPageModel commRecordPageModel) {
        try {
            ValidUtils.validNotNullEx(commRecordPageModel, "id,bookId,page,title,imageUrl");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        //添加page
        CommRecord commRecord = getRecord(commRecordPageModel, true);
        commRecordDao.update(commRecord);
        //添加page block
        commPointReadBlockDao.deleteByRecordId(commRecord.getId());
        addPageBlock(commRecord, commRecordPageModel);
        return ErrorCode.SUCCESS;
    }

    private CommRecord getRecord(CommRecordPageModel commRecordPageModel, boolean mod){
        CommRecord commRecord = new CommRecord();

        commRecord.setClassId(commRecordPageModel.getBookId());
        commRecord.setSortNum(commRecordPageModel.getPage());
        commRecord.setTitle(commRecordPageModel.getTitle());
        commRecord.setLabel("");
        commRecord.setRelativePath(commRecordPageModel.getImageUrl());
        commRecord.setFileSize(0);
        commRecord.setFileType("PIC");
        commRecord.setContentPlain("");
        commRecord.setContentHtml("");
        commRecord.setStatus(ConstantApi.STATUS_OK);
        commRecord.setModifyTime(System.currentTimeMillis());
        if (mod){
            commRecord.setId(commRecordPageModel.getId());
        }
        else {
            commRecord.setCreateTime(System.currentTimeMillis());
        }
        return commRecord;
    }

    @Override
    public ErrorMessage add(CommRecord commRecord) {
        try {
            ValidUtils.validNotNullEx(commRecord, "classId,title");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = commRecordDao.insert(commRecord);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage mod(CommRecord commRecord) {
        try {
            ValidUtils.validNotNullEx(commRecord, "id,classId,title");
        } catch (Exception ex) {
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        int operRes = commRecordDao.update(commRecord);
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }

    @Override
    public ErrorMessage del(CommRecordPara commRecordPara) {
        try{
            ValidUtils.validNotNullEx(commRecordPara, "id");
        } catch (Exception ex){
            ErrorCode.ILLEGAL_ARGUMENT.setResult(ex.getMessage());
            return ErrorCode.ILLEGAL_ARGUMENT;
        }
        commPointReadBlockDao.deleteByRecordId(commRecordPara.getId());
        int operRes = commRecordDao.delete(commRecordPara.getId());
        if(operRes > 0){
            return ErrorCode.SUCCESS;
        }
        else {
            return ErrorCode.DB_ERROR;
        }
    }
}
