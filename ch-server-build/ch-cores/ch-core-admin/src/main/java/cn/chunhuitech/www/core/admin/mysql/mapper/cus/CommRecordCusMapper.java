package cn.chunhuitech.www.core.admin.mysql.mapper.cus;


import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommRecordCusMapper {
    long getLastModifyTimeSql();
    int fetchRecordCountSql(Map<String, Object> param);
}
