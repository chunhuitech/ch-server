package cn.chunhuitech.www.core.admin.dao;



/**
 * Created by hechengjin on 17-10-24.
 */
public interface CommConfigDao {
    Integer getRecordDataVersion(String keyName);
    String getRecordDataDownAddr(String keyName);
}
