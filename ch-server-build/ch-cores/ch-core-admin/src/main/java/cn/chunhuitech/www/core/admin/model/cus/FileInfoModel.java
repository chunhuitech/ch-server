package cn.chunhuitech.www.core.admin.model.cus;

/**
 * Created by hechengjin on 17-10-24.
 */
public class FileInfoModel {
    private Long size;

    private String path;

    private String fileSize;

    private String type;

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
