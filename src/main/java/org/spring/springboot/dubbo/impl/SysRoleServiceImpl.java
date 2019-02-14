package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.spring.springboot.dao.SysRoleMapper;
import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysRole;
import org.spring.springboot.dubbo.SysRoleService;
import org.spring.springboot.response.SysRoleFindResponse;
import org.spring.springboot.utils.UidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(version = "1.0.0",timeout = 30000)
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Override
    public SysRoleFindResponse findAllRoles(PagerQuery<SysRole> search) {
        SysRoleFindResponse sysRoleFindResponse = new SysRoleFindResponse();
        List<SysRole> list = new ArrayList<>();
        Page page =PageHelper.startPage(search.getPage(),search.getLength());
        list = sysRoleMapper.selectEverywhere(search.getSearchValue(), search.getSearchRegex());
        sysRoleFindResponse.setResult(list);
        sysRoleFindResponse.setTotalCount(page.getTotal());
        return sysRoleFindResponse;
    }

    @Override
    public int creatRole(SysRole sysRole) {
        if(sysRole!=null) {
            sysRole.setId(Integer.valueOf(UidUtil.getUIdForSequ()));
            sysRole.setCreatedTime(new Date());
            return sysRoleMapper.insert(sysRole);
        }else {
            return 0;
        }
    }
}
