package cn.chunhuitech.www.api.common.util;

import cn.chunhuitech.www.api.common.model.WXSessionInfo;
import cn.chunhuitech.www.lib.httpclient.HttpClientWrap;
import cn.chunhuitech.www.lib.httpclient.HttpResponseWrap;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * Created by hechengjin on 18-6-20.
 */
public class WxHandleUtil {

    public static final String BASE_WX_URL = "https://api.weixin.qq.com";

    /**
     * 获取微信小程序登录态信息
     * @param appId 小程序appId
     * @param secret 小程序secret
     * @param code 小程序code
     * @return
     */
    public static WXSessionInfo getWxAppSession(String appId, String secret, String code) throws Exception{
        //换取用户登录态信息
        HashMap<String, String> params = new HashMap<>();
        params.put("appid", appId);
        params.put("secret", secret);
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        // logger.info(JsonUtil.encode(params));
//        String res = HttpUtil.sendGet(BASE_WX_URL, "/sns/jscode2session", params);

        HttpResponseWrap<String> response = HttpClientWrap.doGet(params, BASE_WX_URL + "/sns/jscode2session");
        WXSessionInfo sessinfoData = JsonUtil.decode(response.getContent(), WXSessionInfo.class);
        if (!StringUtils.isEmpty(sessinfoData.getErrCode())) {
            return null;
        }

        return sessinfoData;
    }
}
