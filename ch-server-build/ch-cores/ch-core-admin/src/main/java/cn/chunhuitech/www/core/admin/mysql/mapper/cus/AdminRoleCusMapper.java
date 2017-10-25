package cn.chunhuitech.www.core.admin.mysql.mapper.cus;

import cn.chunhuitech.www.core.admin.model.cus.AdminRoleCus;

import java.util.List;
import java.util.Map;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminRoleCusMapper {
    List<AdminRoleCus> getListSql(Map<String, Object> param);
    long getListCountSql(Map<String, Object> param);
}
