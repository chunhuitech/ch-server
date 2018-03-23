package cn.chunhuitech.www.api.admin.model;

import java.util.List;

public class AdminRightInfoBo {
    private String userName;
    private List<RightMenuTree> menus;          // 权限菜单

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<RightMenuTree> getMenus() {
        return menus;
    }

    public void setMenus(List<RightMenuTree> menus) {
        this.menus = menus;
    }
}