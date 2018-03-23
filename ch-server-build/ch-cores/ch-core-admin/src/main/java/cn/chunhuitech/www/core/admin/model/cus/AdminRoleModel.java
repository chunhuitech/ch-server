package cn.chunhuitech.www.core.admin.model.cus;


import java.util.List;

/**
 * Created by hechengjin on 17-10-24.
 */
public class AdminRoleModel {
    private Integer id;

    private Integer systemId;

    private String name;

    private String des;

    private List<Integer> menus;

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

    public List<Integer> getMenus() {
        return menus;
    }

    public void setMenus(List<Integer> menus) {
        this.menus = menus;
    }
}
