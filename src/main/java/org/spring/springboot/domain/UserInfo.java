package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

import java.util.ArrayList;
import java.util.List;


public class UserInfo extends BaseDomain {
    private SysUser user;
    private UserInfo.Menu rootMenu;
    private List<List<Menu>> menuPaths;

    public void addMenuPath(List<Menu> menuPath) {
        this.menuPaths.add(menuPath);
    }

    public SysUser getUser() {
        return this.user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public UserInfo.Menu getRootMenu() {
        return this.rootMenu;
    }

    public void setRootMenu(UserInfo.Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

    public List<List<Menu>> getMenuPaths() {
        return this.menuPaths;
    }

    public void setMenuPaths(List<List<Menu>> menuPaths) {
        this.menuPaths = menuPaths;
    }

    public UserInfo() {
        this.menuPaths = new ArrayList();
    }


    public String toString() {
        return "UserInfo(user=" + getUser() + ", rootMenu=" + getRootMenu() + ", menuPaths=" + getMenuPaths() + ")";
    }

    public class Menu {
        private Integer id;
        private String menuName;
        private String menuIcon;
        private String menuDesc;
        private String menuType;
        private String menuHref;
        private List<Menu> subMenus = new ArrayList();
        private Integer sort;
        private String isShow;

        public void addSubMenu(Menu subMenu) {
            this.subMenus.add(subMenu);
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

        public String getMenuIcon() {
            return this.menuIcon;
        }

        public void setMenuIcon(String menuIcon) {
            this.menuIcon = menuIcon;
        }

        public String getMenuDesc() {
            return this.menuDesc;
        }

        public void setMenuDesc(String menuDesc) {
            this.menuDesc = menuDesc;
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

        public List<Menu> getSubMenus() {
            return this.subMenus;
        }

        public void setSubMenus(List<Menu> subMenus) {
            this.subMenus = subMenus;
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

        public String toString() {
            return "UserInfo.Menu(id=" + getId() + ", menuName=" + getMenuName() + ", menuIcon=" + getMenuIcon() + ", menuDesc=" + getMenuDesc() + ", menuType=" + getMenuType() + ", menuHref=" + getMenuHref() + ", subMenus=" + getSubMenus() + ", sort=" + getSort() + ", isShow=" + getIsShow() + ")";
        }
    }
}
