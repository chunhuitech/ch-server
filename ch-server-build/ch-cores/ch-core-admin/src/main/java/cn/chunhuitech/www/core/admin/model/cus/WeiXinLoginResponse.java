package cn.chunhuitech.www.core.admin.model.cus;

/**
 * Created by hechengjin on 18-6-22.
 */
public class WeiXinLoginResponse {

    private Integer userId;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
