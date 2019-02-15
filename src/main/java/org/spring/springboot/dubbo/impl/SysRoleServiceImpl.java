package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.spring.springboot.base.base.ErrorType;
import org.spring.springboot.dao.SysRoleMapper;
import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysRole;
import org.spring.springboot.dubbo.SysRoleService;
import org.spring.springboot.response.SysRoleCreateResponse;
import org.spring.springboot.response.SysRoleDeleteResponse;
import org.spring.springboot.response.SysRoleFindResponse;
import org.spring.springboot.response.SysRoleUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
    public int getByNameTotal(String name) {
        if(name==null){
            return 0;
        }else{
            return sysRoleMapper.getByNameTotal(name);
        }
    }

    @Override
    public SysRole getById(Integer id) {
       return sysRoleMapper.selectById(id);
    }

    @Override
    public SysRoleDeleteResponse deleteById(Integer id) {
        SysRoleDeleteResponse response = new SysRoleDeleteResponse();
        SysRole sysRole = sysRoleMapper.selectById(id);
        if(sysRole==null){
           response.addError(ErrorType.BUSINESS_ERROR,"不存在的角色，不可删除");
       }
            int res=sysRoleMapper.deleteById(id);
            response.setResult(res);
             if(res!=1){
                 response.addError(ErrorType.BUSINESS_ERROR,"删除失败");
             }
        return response;
    }

    @Override
    public SysRoleCreateResponse creatRole(SysRole sysRole) {
        SysRoleCreateResponse response = new SysRoleCreateResponse();
        if(sysRole!=null) {
            if(0!=sysRoleMapper.getByNameTotal(sysRole.getRoleName())){
                response.addError(ErrorType.BUSINESS_ERROR,"角色名称已经存在");
                return response;
            }
            int maxid = sysRoleMapper.getMaxId();
            int id=maxid+1;
            sysRole.setId(id);
            sysRole.setCreatedTime(new Date());
            response.setResult(sysRoleMapper.insert(sysRole));
            if(1!=response.getResult()){
                response.addError(ErrorType.BUSINESS_ERROR,"创建失败！！！");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }else {
            response.addError(ErrorType.BUSINESS_ERROR,"传入的对象不能为空");
        }
        return  response;
    }

    @Override
    public SysRoleUpdateResponse updateRole(SysRole sysRole) {
        SysRoleUpdateResponse response = new SysRoleUpdateResponse();
        if(sysRole==null){
           response.addError(ErrorType.BUSINESS_ERROR,"对象不能为空");
        }
        int res=sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        if(res==1){
            response.setResult(1);
        }else{
            response.addError(ErrorType.BUSINESS_ERROR,"更新失败！！！");
        }
        return response;
    }
}
