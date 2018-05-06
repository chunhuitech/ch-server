package cn.chunhuitech.www.core.admin.model.cus;

/**
 * Created by hechengjin on 18-2-22.
 */
public class CommClassificationPara {
    private Integer id;
    private Integer parentId;
    private long syncTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public long getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(long syncTime) {
        this.syncTime = syncTime;
    }
}
