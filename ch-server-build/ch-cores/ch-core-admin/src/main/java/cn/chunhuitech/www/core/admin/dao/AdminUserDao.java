package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface AdminUserDao {
    List<AdminUser> getList(AdminUserPara adminUserPara);
    long getListCount(AdminUserPara adminUserPara);
    long getWxUserCount();

    int insert(AdminUser adminUser);
    AdminUser getById(Integer id);
    AdminUser getByUserName(String username);
    AdminUser getByToken(String token);
    AdminUser getByOpenId(String OpenId);
    int update(AdminUser adminUser);
    int delete(int id);
    boolean exist(Integer id, String userName);
    boolean verifyUser(Integer id, String userName);
    boolean existByOpenId(String openId);
}
