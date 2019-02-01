package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.spring.springboot.dao.SysMenuMapper;
import org.spring.springboot.dao.SysRoleMenuMapper;
import org.spring.springboot.domain.SysMenu;
import org.spring.springboot.dubbo.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
@Service(version = "1.0.0",timeout = 30000)
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> selectMenuByUser(Integer userId) {
        return this.sysMenuMapper.selectMenuByUserId(userId);
    }

    private SysMenu findSysMenu(SysMenu rootMenu, Integer menuId) {
        if (rootMenu.getId().equals(menuId)) {
            return rootMenu;
        }
        List subMenus = rootMenu.getSubMenus();
        for (int i = 0; i < subMenus.size(); i++) {
            SysMenu subMenu = (SysMenu) subMenus.get(i);
            SysMenu found = findSysMenu(subMenu, menuId);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    private void buildSysMenu(SysMenu rootMenu, List<SysMenu> menus) {
        if (menus.size() > 0) {
            rootMenu.setId(((SysMenu) menus.get(0)).getId());
            for (int i = 1; i < menus.size(); i++) {
                SysMenu current = (SysMenu) menus.get(i);
                SysMenu target = findSysMenu(rootMenu, current.getParentMenu().getId());
                target.addSubMenu(current);
            }
        }
    }

    public void findPath(List<SysMenu> menuPath, Stack<SysMenu> menuPathStack, Integer menuId, List<SysMenu> menus) {
        if ((menus != null) && (!menus.isEmpty())) {
            for (int i = 0; i < menus.size(); i++) {
                SysMenu menu = (SysMenu) menus.get(i);
                menuPathStack.add(menu);
                if (menu.getSubMenus().isEmpty()) {
                    if (!menuPathStack.isEmpty()) {
                        SysMenu top = (SysMenu) menuPathStack.peek();
                        if (menuId.equals(top.getId())) {
                            menuPath.clear();
                            while (!menuPathStack.isEmpty()) {
                                menuPath.add(menuPathStack.pop());
                            }
                            Collections.reverse(menuPath);
                            return;
                        }
                    }
                    menuPathStack.pop();
                } else {
                    findPath(menuPath, menuPathStack, menuId, menu.getSubMenus());
                }
            }
            if (!menuPathStack.isEmpty())
                menuPathStack.pop();
        }
    }

    @Override
    public Map<String, Object> getAllMenu(long userid) {
        SysMenu rootMenu = new SysMenu();
        List menus = this.sysMenuMapper.getAllRootMenu();
        buildSysMenu(rootMenu, menus);

        List funcs = this.sysMenuMapper.getFunctionByUserId(userid);

        List allPaths = new ArrayList();
        for (int i = 0; i < funcs.size(); i++) {
            SysMenu func = (SysMenu) funcs.get(i);
            List menuPath = new ArrayList();
            Stack menuPathStack = new Stack();
            findPath(menuPath, menuPathStack, func.getId(), rootMenu.getSubMenus());
            if (!menuPath.isEmpty()) {
                allPaths.add(menuPath);
            }
        }

        List newAllPaths = new ArrayList();
        for (int i = 0; i < allPaths.size(); i++) {
            List oldPath = (List) allPaths.get(i);
            List newPath = new ArrayList();

            for (int j = 0; j < oldPath.size(); j++) {
                SysMenu oldNode = (SysMenu) oldPath.get(j);
                SysMenu newNode = copySysMenu(oldNode);
                newPath.add(newNode);
            }
            newAllPaths.add(newPath);
        }

        List targetAllPaths = new ArrayList();
        for (int i = 0; i < newAllPaths.size(); i++) {
            List newPath = (List) newAllPaths.get(i);

            int leafCount = 0;
            for (int j = 0; j < newPath.size(); j++) {
                SysMenu old = (SysMenu) newPath.get(j);
                if ("F".equalsIgnoreCase(old.getMenuType())) {
                    leafCount++;
                }
            }
            for (int j = 0; j < leafCount; j++) {
                wapperMenuPath(targetAllPaths, newPath, j + 1);
            }

        }

        SysMenu newRootMenu = new SysMenu();
        newRootMenu.setId(rootMenu.getId());
        for (int i = 0; i < allPaths.size(); i++) {
            List path = (List) allPaths.get(i);
            buildMenu(newRootMenu, path);
        }

        Map map = new HashMap();
        map.put("path", targetAllPaths);
        map.put("root", newRootMenu);
        return map;
    }

    private void wapperMenuPath(List<List<SysMenu>> targetAllPaths, List<SysMenu> newPath, int index) {
        SysMenu[] newPathArray = new SysMenu[newPath.size()];
        newPath.toArray(newPathArray);

        int count = 0;
        for (int i = 0; i < newPath.size(); i++) {
            SysMenu current = (SysMenu) newPath.get(i);
            if ("F".equalsIgnoreCase(current.getMenuType())) {
                count++;
            }

            if (index == count) {
                SysMenu[] tmp = (SysMenu[]) Arrays.copyOf(newPathArray, i + 1);
                if (tmp.length > 0)
                    addTargetAllPaths(targetAllPaths, Arrays.asList(tmp));
            }
        }
    }

    private void addTargetAllPaths(List<List<SysMenu>> targetAllPaths, List<SysMenu> tmp) {
        targetAllPaths.add(tmp);
    }

    private void buildMenu(SysMenu newRootMenu, List<SysMenu> paths) {
        for (int i = 0; i < paths.size(); i++) {
            SysMenu node = (SysMenu) paths.get(i);
            SysMenu target = findSysMenu(newRootMenu, node.getParentMenu().getId());
            if (target != null) {
                boolean found = false;
                List submenus = target.getSubMenus();
                for (int j = 0; j < submenus.size(); j++) {
                    if (((SysMenu) submenus.get(j)).getId().equals(node.getId())) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    target.addSubMenu(copySysMenu(node));
            }
        }
    }

    private SysMenu copySysMenu(SysMenu menu) {
        SysMenu target = new SysMenu();
        target.setId(menu.getId());
        target.setMenuIcon(menu.getMenuIcon());
        target.setMenuName(menu.getMenuName());
        target.setMenuDesc(menu.getMenuDesc());
        target.setMenuHref(menu.getMenuHref());
        target.setMenuType(menu.getMenuType());
        target.setIsShow(menu.getIsShow());
        target.setSort(menu.getSort());
        target.setParentId(menu.getParentMenu().getId());
        return target;
    }
}
