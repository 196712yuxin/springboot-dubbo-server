package org.spring.springboot.dubbo;

import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysRoleMenu;
import org.spring.springboot.domain.SysUser;
import org.spring.springboot.response.SysRoleMenuCreateResponse;
import org.spring.springboot.response.SysRoleMenuFindResponse;

public interface SysRoleMenuService {
    public int hasPrivilleges(Integer id, String url);
    public SysRoleMenuFindResponse findRoleMenu(PagerQuery<SysRoleMenu> search);
    public  int physicalDeletion(Integer id);
    public SysRoleMenuCreateResponse createRoleMenu(SysRoleMenu sysRoleMenu);
}
