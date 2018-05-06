package cn.chunhuitech.www.core.admin.model.cus;

/**
 * Created by hechengjin on 18-2-22.
 */
public class CommRecordPara {
    private Integer classId;
    private long syncTime;
    private String pages;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public long getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(long syncTime) {
        this.syncTime = syncTime;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}
