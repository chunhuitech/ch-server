package cn.chunhuitech.www.api.admin.model;



public class CommConfigBo {
    Integer recordDataVersion;
    String recordDataDownAddr;

    public Integer getRecordDataVersion() {
        return recordDataVersion;
    }

    public void setRecordDataVersion(Integer recordDataVersion) {
        this.recordDataVersion = recordDataVersion;
    }

    public String getRecordDataDownAddr() {
        return recordDataDownAddr;
    }

    public void setRecordDataDownAddr(String recordDataDownAddr) {
        this.recordDataDownAddr = recordDataDownAddr;
    }
}