package cn.chunhuitech.www.api.common.model;

/**
 * Created by hechengjin on 18-6-13.
 */
public abstract class WXErrorCode {
    /** 成功 */
    public static final Integer SUCCESS = 0;
    /** 未知 */
    public static final Integer UNKNOWN = -1;

    /** 未知错误 */
    public static final WXResult.Error ERROR_UNKNOWN = new WXResult.Error(UNKNOWN, "unknown error");

    /** 参数错误,不正确的参数 */
    public static final WXResult.Error ARGUMENT_INVALID = new WXResult.Error(1, "parameter is invalid");


    /** 参数错误 */
    public static final WXResult.Error LOGIN_PARAM_ERROR = new WXResult.Error(100, "login param error, or login expire");
    /** 登陆超时 */
    public static final WXResult.Error LOGIN_EXPIRE = new WXResult.Error(101, "login expire");
    /** 参数Token错误 */
    public static final WXResult.Error LOGIN_PARAM_TOKEN_ERROR = new WXResult.Error(102, "login token error");

}
