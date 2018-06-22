package cn.chunhuitech.www.api.common.model;

/**
 * Created by hechengjin on 18-6-21.
 */
public class WxWaterMark {
    private long timestamp;
    private String appid;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
