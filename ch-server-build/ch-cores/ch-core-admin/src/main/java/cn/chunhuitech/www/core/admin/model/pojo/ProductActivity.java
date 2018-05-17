package cn.chunhuitech.www.core.admin.model.pojo;

public class ProductActivity {
    private Long id;

    private Long userId;

    private String clientFlag;

    private String procName;

    private String procVersion;

    private Long procId;

    private String os;

    private String eventName;

    private String ip;

    private String netIp;

    private String area;

    private Integer eventCount;

    private Long modifyTime;

    private Long createTime;

    private String remarks;

    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getClientFlag() {
        return clientFlag;
    }

    public void setClientFlag(String clientFlag) {
        this.clientFlag = clientFlag == null ? null : clientFlag.trim();
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName == null ? null : procName.trim();
    }

    public String getProcVersion() {
        return procVersion;
    }

    public void setProcVersion(String procVersion) {
        this.procVersion = procVersion == null ? null : procVersion.trim();
    }

    public Long getProcId() {
        return procId;
    }

    public void setProcId(Long procId) {
        this.procId = procId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getNetIp() {
        return netIp;
    }

    public void setNetIp(String netIp) {
        this.netIp = netIp == null ? null : netIp.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}