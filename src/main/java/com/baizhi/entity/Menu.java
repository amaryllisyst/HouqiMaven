package com.baizhi.entity;

import java.util.List;

public class Menu {
    private String id;
    private String name;
    private String iconCls;
    private String href;
    private List<Menu> menus;

    public String getIs() {
        return id;
    }

    public void setIs(String is) {
        this.id = is;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu() {

    }

    public Menu(String id, String name, String iconCls, String href, List<Menu> menus) {

        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", menus=" + menus +
                '}';
    }
}
