package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommResource;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommResourceDao {
    List<CommResource> fetchResource(CommClassificationPara commClassificationPara);
    int insert(CommResource commResource);
    CommResource getById(Integer id);
    int update(CommResource commResource);
    int delete(int id);
}
