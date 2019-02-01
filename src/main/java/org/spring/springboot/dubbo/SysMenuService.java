package org.spring.springboot.dubbo;

import org.spring.springboot.domain.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {
    public List<SysMenu> selectMenuByUser(Integer userId);
    public Map<String, Object> getAllMenu(long userid);
}
