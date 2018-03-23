package cn.chunhuitech.www.api.admin.model;

import java.util.List;

public class AdminRoleInfoBo {
    private Integer id;

    private Integer systemId;

    private String name;

    private String des;

    private List<RightMenuTree> menus;          // 权限菜单

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<RightMenuTree> getMenus() {
        return menus;
    }

    public void setMenus(List<RightMenuTree> menus) {
        this.menus = menus;
    }
}