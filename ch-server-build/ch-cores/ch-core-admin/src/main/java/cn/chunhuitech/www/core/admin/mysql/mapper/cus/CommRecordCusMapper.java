package cn.chunhuitech.www.core.admin.mysql.mapper.cus;


import cn.chunhuitech.www.core.admin.model.cus.CommRecordPageModel;

import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommRecordCusMapper {
    long getLastModifyTimeSql();
    int fetchRecordCountSql(Map<String, Object> param);

    List<CommRecordPageModel> fetchRecordPageSql(Map<String, Object> param);
    int fetchRecordPageCountSql(Map<String, Object> param);
}
