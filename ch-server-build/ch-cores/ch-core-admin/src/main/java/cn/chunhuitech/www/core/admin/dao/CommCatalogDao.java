package cn.chunhuitech.www.core.admin.dao;

import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommCatalog;

import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommCatalogDao {
    List<CommCatalog> fetchCatalog(CommCatalogPara commCatalogPara);
}
