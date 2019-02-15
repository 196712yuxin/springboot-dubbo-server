package org.spring.springboot.dubbo;

import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysRole;
import org.spring.springboot.response.SysRoleCreateResponse;
import org.spring.springboot.response.SysRoleDeleteResponse;
import org.spring.springboot.response.SysRoleFindResponse;
import org.spring.springboot.response.SysRoleUpdateResponse;

public interface SysRoleService {
    public SysRoleFindResponse findAllRoles(PagerQuery<SysRole> search);
    public int getByNameTotal(String name);
    public SysRole getById(Integer id);
    public SysRoleDeleteResponse deleteById(Integer id);
    public SysRoleCreateResponse creatRole(SysRole sysRole);
    public SysRoleUpdateResponse updateRole(SysRole sysRole);
}
