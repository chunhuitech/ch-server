package cn.chunhuitech.www.core.common.constant;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface ConstantCore {
    //通用状态 0==正常 ,1==删除  127 无效
    byte STATUS_OK = 0;
    byte STATUS_DELETE = 1;
    byte STATUS_INVALID = 127;

    //是否显示 0不显示 1 显示
    byte STATUS_SHOW_NO = 0;
    byte STATUS_SHOW_YES = 1;
    byte STATUS_SHOW_ALL = 127;

    //分类对应的数据类型 1 PC资源(flash) 2 点读资源  3 首页门户查询
    int STATUS_CLASS_DATA_TYPE_PC = 1;
    int STATUS_CLASS_DATA_TYPE_DIANDU = 2;
    int STATUS_CLASS_DATA_TYPE_PORTAL = 3;
    int STATUS_CLASS_DATA_TYPE_ALL = 127;
}
