package cn.chunhuitech.www.core.admin.model.cus;

/**
 * Created by hechengjin on 18-6-13.
 */
public class WeiXinLoginParam {
    private String code;

    private String encryptedData;

    private String iv;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
