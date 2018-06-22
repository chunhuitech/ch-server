/*
 * 文件名：WXBizDataCrypt.java
 * 版权：
 * 描述：
 * 修改人：Awoke
 * 修改时间：2018-1-24
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package cn.chunhuitech.www.api.common.util;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;


/**
 * 对微信小程序用户加密数据的解密示例代码.
 * @author Awoke
 * @version 2018-1-24
 * @see WXBizDataCrypt
 * @since
 */
public class WXBizDataCrypt
{

    private String appid;

    private String sessionKey;

    public WXBizDataCrypt(String appid, String sessionKey)
    {
        this.appid = appid;
        this.sessionKey = sessionKey;
    }

    /**
     * 检验数据的真实性，并且获取解密后的明文.
     * @param encryptedData string 加密的用户数据
     * @param iv string 与用户数据一同返回的初始向量
     *
     * @return data string 解密后的原文
     */
    public String decryptData(String encryptedData, String iv)
    {
        if (StringUtils.length(sessionKey) != 24)
        {
            return "ErrorCode::$IllegalAesKey;";
        }
        // 对称解密秘钥 aeskey = Base64_Decode(session_key), aeskey 是16字节。
        byte[] aesKey = Base64.decodeBase64(sessionKey);

        if (StringUtils.length(iv) != 24)
        {
            return "ErrorCode::$IllegalIv;";
        }
        // 对称解密算法初始向量 为Base64_Decode(iv)，其中iv由数据接口返回。
        byte[] aesIV = Base64.decodeBase64(iv);

        // 对称解密的目标密文为 Base64_Decode(encryptedData)
        byte[] aesCipher = Base64.decodeBase64(encryptedData);

        Map<String, String> map = new HashMap<>();

        try
        {
            byte[] resultByte = AESUtils.decrypt(aesCipher, aesKey, aesIV);

            if (null != resultByte && resultByte.length > 0)
            {
                String userInfo = new String(resultByte, "UTF-8");

                map.put("code", "0000");
                map.put("msg", "succeed");
                map.put("userInfo", userInfo);
                // watermark参数说明：
                // 参数  类型  说明
                // watermark   OBJECT  数据水印
                // appid   String  敏感数据归属appid，开发者可校验此参数与自身appid是否一致
                // timestamp   DateInt 敏感数据获取的时间戳, 开发者可以用于数据时效性校验'

                // 根据微信建议：敏感数据归属appid，开发者可校验此参数与自身appid是否一致
                // if decrypted['watermark']['appid'] != self.appId:
                JSONObject jsons = JSON.parseObject(userInfo);
                String id = jsons.getJSONObject("watermark").getString("appid");
                if(!StringUtils.equals(id, appid))
                {
                    return "ErrorCode::$IllegalBuffer;";
                }
            }
            else
            {
                map.put("status", "1000");
                map.put("msg", "false");
            }
        }
        catch (InvalidAlgorithmParameterException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }

}