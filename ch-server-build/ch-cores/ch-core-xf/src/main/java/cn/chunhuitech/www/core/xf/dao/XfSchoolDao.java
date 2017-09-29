package cn.chunhuitech.www.core.xf.dao;

import cn.chunhuitech.www.core.xf.model.cus.XfSchoolPara;
import cn.chunhuitech.www.core.xf.model.pojo.XfSchool;

import java.util.List;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface XfSchoolDao {
    List<XfSchool> getList(XfSchoolPara xfSchoolPara);
    long getListCount(XfSchoolPara xfSchoolPara);

}
