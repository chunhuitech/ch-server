package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageBlockModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommRecordDao {
    List<CommRecord> fetchRecord(CommRecordPara commRecordPara);
    Integer fetchRecordCount(CommRecordPara commRecordPara);
    Long getLastModifyTime();

    List<CommRecordPageBlockModel> fetchRecordPage(CommRecordPara commRecordPara);
    Integer fetchRecordPageCount(CommRecordPara commRecordPara);


    List<CommRecordSearchModel> getList(CommRecordPara commRecordPara);
    long getListCount(CommRecordPara commRecordPara);

    int insert(CommRecord commRecord);
    int update(CommRecord commRecord);
    int delete(int id);

}
