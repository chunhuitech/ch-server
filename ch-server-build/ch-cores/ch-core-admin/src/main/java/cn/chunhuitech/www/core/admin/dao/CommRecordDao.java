package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommRecord;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommRecordDao {
    List<CommRecord> fetchRecord(CommRecordPara commRecordPara);
}
