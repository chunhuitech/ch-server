package cn.chunhuitech.www.api.admin.model;

import java.util.List;

/**
 * Created by hechengjin on 18-3-18.
 */
public class RightMenuTree {
    private Integer id;
    private Integer parentId;
    private String name;
    private String path;
    private String icon;
    private String resUrl;
    private List<RightMenuTree> children;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public List<RightMenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<RightMenuTree> children) {
        this.children = children;
    }
}
