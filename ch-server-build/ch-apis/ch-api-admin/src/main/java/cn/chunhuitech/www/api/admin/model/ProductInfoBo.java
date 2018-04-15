package cn.chunhuitech.www.api.admin.model;



public class ProductInfoBo {
    String downAddress;
    Integer versionNum;
    String version;

    public String getDownAddress() {
        return downAddress;
    }

    public void setDownAddress(String downAddress) {
        this.downAddress = downAddress;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}