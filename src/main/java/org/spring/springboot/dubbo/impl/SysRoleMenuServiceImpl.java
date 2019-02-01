package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.spring.springboot.dao.SysRoleMenuMapper;
import org.spring.springboot.dubbo.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
@Service(version = "1.0.0")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
        @Autowired
        private SysRoleMenuMapper sysRoleMenuMapper;

        public int hasPrivilleges(Integer id, String url)
        {
            return this.sysRoleMenuMapper.hasPrivilleges(id, url);
        }
}
