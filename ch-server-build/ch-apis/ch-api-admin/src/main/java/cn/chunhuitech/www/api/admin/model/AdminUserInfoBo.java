package cn.chunhuitech.www.api.admin.model;

import java.util.List;

public class AdminUserInfoBo {
    private List<String> role;
    private String name;
    private String avatar;

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}