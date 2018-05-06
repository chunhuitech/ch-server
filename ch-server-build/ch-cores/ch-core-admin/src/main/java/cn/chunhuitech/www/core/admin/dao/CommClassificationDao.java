package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleSearchModel;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommClassificationDao {
    List<CommClassification> fetchClass(CommClassificationPara commClassificationPara);
    Long getLastModifyTime();
    List<CommClassification> fetchChildren(CommClassificationPara commClassificationPara);

}
