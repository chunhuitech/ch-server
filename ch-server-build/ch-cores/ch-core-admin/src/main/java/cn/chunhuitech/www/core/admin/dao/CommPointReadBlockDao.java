package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.CommPointReadBlockPara;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageBlockModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommPointReadBlockDao {

    int insert(CommPointReadBlock commPointReadBlock);
    int update(CommPointReadBlock commPointReadBlock);
    int delete(int id);
    int deleteByRecordId(Integer recordId);
    CommPointReadBlock getById(Integer id);
    List<CommPointReadBlock> fetchPointBlock(CommPointReadBlockPara commPointReadBlockPara);
    List<CommPointReadBlock> fetchPointBlockByResourceId(Integer resourceId);
}
