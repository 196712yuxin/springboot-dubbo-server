package org.spring.springboot.dubbo;

import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysRole;
import org.spring.springboot.response.SysRoleFindResponse;

public interface SysRoleService {
    public SysRoleFindResponse findAllRoles(PagerQuery<SysRole> search);
    public int creatRole(SysRole sysRole);
}
