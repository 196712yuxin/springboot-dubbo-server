package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.spring.springboot.base.base.ErrorType;
import org.spring.springboot.dao.SysRoleMenuMapper;
import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysRoleMenu;
import org.spring.springboot.domain.SysUser;
import org.spring.springboot.dubbo.SysRoleMenuService;
import org.spring.springboot.response.SysRoleMenuCreateResponse;
import org.spring.springboot.response.SysRoleMenuFindResponse;
import org.spring.springboot.response.SysRoleMenuResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
        @Autowired
        private SysRoleMenuMapper sysRoleMenuMapper;

        public int hasPrivilleges(Integer id, String url)
        {
            return this.sysRoleMenuMapper.hasPrivilleges(id, url);
        }

        @Override
        public SysRoleMenuFindResponse findRoleMenu(PagerQuery<SysRoleMenu> search) {
                String value =  search.getSearch().getId()+"";
                SysRoleMenuFindResponse sysRoleMenuFindResponse = new SysRoleMenuFindResponse();
                Page page =PageHelper.startPage(search.getPage(),search.getLength());
                search.setSearchValue(value);
                List<SysRoleMenuResponse> list =  sysRoleMenuMapper.selectEverywhereId(search.getSearchValue(), search.getSearchRegex());
                sysRoleMenuFindResponse.setResult(list);
                sysRoleMenuFindResponse.setTotalCount(page.getTotal());
                return sysRoleMenuFindResponse;
        }

        @Override
        public int physicalDeletion(Integer id) {
                return sysRoleMenuMapper.deleteById(id);
        }

        @Override
        public SysRoleMenuCreateResponse createRoleMenu(SysRoleMenu sysRoleMenu) {
            SysRoleMenuCreateResponse sysRoleMenuCreateResponse = new SysRoleMenuCreateResponse();
            int req=  sysRoleMenuMapper.insert(sysRoleMenu);
            if(req!=1){
                sysRoleMenuCreateResponse.addError(ErrorType.BUSINESS_ERROR,"添加失败");
                return  sysRoleMenuCreateResponse;
            }
            sysRoleMenuCreateResponse.setResult(req);

            return  sysRoleMenuCreateResponse;
        }
}
