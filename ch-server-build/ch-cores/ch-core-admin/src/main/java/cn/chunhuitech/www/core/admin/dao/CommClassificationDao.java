package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommClassificationDao {
    List<CommClassification> fetchClass(CommClassificationPara commClassificationPara, Byte showFlag, Integer classDataType);
    Long getLastModifyTime();
    List<CommClassification> fetchChildren(CommClassificationPara commClassificationPara, Byte showFlag, Integer classDataType);
    List<CommClassification> fetchAll(Byte showFlag, Integer classDataType);

    int insert(CommClassification commClassification);
    CommClassification getById(Integer id);
    int update(CommClassification commClassification);
    int delete(int id);

}
