package cn.chunhuitech.www.core.admin.mysql.mapper.cus;


import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageBlockModel;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordSearchModel;

import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommRecordCusMapper {
    long getLastModifyTimeSql();
    int fetchRecordCountSql(Map<String, Object> param);

    List<CommRecordPageBlockModel> fetchRecordPageSql(Map<String, Object> param);
    int fetchRecordPageCountSql(Map<String, Object> param);


    List<CommRecordSearchModel> getListSql(Map<String, Object> param);
    long getListCountSql(Map<String, Object> param);
}
