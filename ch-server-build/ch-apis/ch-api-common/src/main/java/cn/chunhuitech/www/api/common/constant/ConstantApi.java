package cn.chunhuitech.www.api.common.constant;

/**
 * Created by hechengjin on 17-9-29.
 */
public interface ConstantApi {
    public static final String MEDIA_TYPE_APPLICATION_JSON = "application/json;charset=UTF-8";
    public static final String MEDIA_TYPE_TEXT_PLAIN  = "text/plain;charset=UTF-8";
    public static final String MEDIA_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";

    public static final String PARAM_USER_TOKEN = "userToken";
    public static final String PARAM_SECURITY_PRODUCTID = "productId";
    public static final String PARAM_SECURITY_PRODUCVERSION = "productVersion";
    public static final String PARAM_SECURITY_UUID = "uuid";
    public static final String PARAM_SECURITY_TIME = "time";
    public static final String PARAM_SECURITY_SIGN = "sign";
    public static final String PARAM_SECURITY_TOKEN = "token";
    public static final String ALGORITHM_MD5 = "MD5";

    byte STATUS_OK = 0;
}
