package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.AdminSystemPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminSystem;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminSystemDao {
    List<AdminSystem> getList(AdminSystemPara adminSystemPara);
    long getListCount(AdminSystemPara adminSystemPara);

    int insert(AdminSystem adminSystem);
    AdminSystem getById(Integer id);
    int update(AdminSystem adminSystem);
    int delete(int id);
}
