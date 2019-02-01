package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenu extends BaseDomain
        implements Serializable, Comparable<SysMenu> {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String menuName;
    private String menuDesc;
    private String menuIcon;
    private String menuType;
    private String menuHref;
    private Integer parentId;
    private Integer sort;
    private String isShow;
    private String isActive;
    private Integer createdBy;
    private Date createdTime;
    private Integer lastUpdatedBy;
    private Date lastUpdatedTime;
    private SysMenu parentMenu;
    private List<SysMenu> subMenus = new ArrayList();

    public static long getSerialVersionUID() {
        return 1L;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return this.menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuIcon() {
        return this.menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuHref() {
        return this.menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsShow() {
        return this.isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public SysMenu getParentMenu() {
        return this.parentMenu;
    }

    public void setParentMenu(SysMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public void setSubMenus(List<SysMenu> subMenus) {
        this.subMenus = subMenus;
    }

    public List<SysMenu> getSubMenus() {
        return this.subMenus;
    }

    public void addSubMenu(SysMenu menu) {
        for (int i = 0; i < this.subMenus.size(); i++) {
            SysMenu subMenu = (SysMenu) this.subMenus.get(i);
            if (menu.getSort().intValue() <= subMenu.getSort().intValue()) {
                this.subMenus.add(i, menu);
                return;
            }
        }
        this.subMenus.add(menu);
    }

    public int compareTo(SysMenu m) {
        return getSort().intValue() > m.getSort().intValue() ? 1 : -1;
    }


    public String toString() {
        return "SysMenu(id=" + getId() + ", menuName=" + getMenuName() + ", menuDesc=" + getMenuDesc() + ", menuIcon=" + getMenuIcon() + ", menuType=" + getMenuType() + ", menuHref=" + getMenuHref() + ", parentId=" + getParentId() + ", sort=" + getSort() + ", isShow=" + getIsShow() + ", isActive=" + getIsActive() + ", createdBy=" + getCreatedBy() + ", createdTime=" + getCreatedTime() + ", lastUpdatedBy=" + getLastUpdatedBy() + ", lastUpdatedTime=" + getLastUpdatedTime() + ", parentMenu=" + getParentMenu() + ", subMenus=" + getSubMenus() + ")";
    }
}