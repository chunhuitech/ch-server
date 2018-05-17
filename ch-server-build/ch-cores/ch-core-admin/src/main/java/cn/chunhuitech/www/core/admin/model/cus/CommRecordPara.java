package cn.chunhuitech.www.core.admin.model.cus;

/**
 * Created by hechengjin on 18-2-22.
 */
public class CommRecordPara {
    private Integer id;
    private Integer classId;
    private long syncTime;
    private String pages;

    private Integer page;
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getPage() {

        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
