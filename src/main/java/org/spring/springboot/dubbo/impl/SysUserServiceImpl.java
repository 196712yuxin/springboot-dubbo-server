package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.spring.springboot.dao.SysUserMapper;
import org.spring.springboot.domain.ErrorStatus;
import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysUser;
import org.spring.springboot.dubbo.SysUserService;
import org.spring.springboot.response.SysUserFindResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(version = "1.0.0",timeout = 30000)
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser selectByPrimaryKey(Integer id)
    {
         return this.sysUserMapper.selectByPrimaryKey(id);
    }
    @Override
    public Map<String, Object> login(String username, String password, String ip, ErrorStatus errorStatus) {
        Map map = new HashMap();
        Map param = new HashMap();
        param.put("user", username);
        param.put("pwd", password);
        param.put("ip", ip);
        param.put("login_user_id", null);
        param.put("err_code", null);
        param.put("err_msg", null);
        this.sysUserMapper.getUserByUsernameAndPassword(param);

        int errorCode = Integer.parseInt(String.format("%d", new Object[] { param.get("err_code") }));
        if ((errorCode == 0) || (errorCode == 1)) {
            map.put("code", Integer.valueOf(errorCode));
            map.put("msg", String.format("%s", new Object[] { param.get("err_msg") }));
            map.put("domain", this.sysUserMapper.selectByPrimaryKey(Integer.valueOf(Integer.parseInt(String.format("%d", new Object[] { param.get("login_user_id") })))));
            return map;
        }
        if (errorStatus != null) {
            errorStatus.setErrorCode(errorCode);
            errorStatus.setErrorMessage(String.format("%s", new Object[] { param.get("err_msg") }));
        }
        return null;
    }
    @Override
    public SysUserFindResponse selectEverywhere(PagerQuery<SysUser> search) {
        SysUserFindResponse response = new SysUserFindResponse();
        List<SysUser> list = new ArrayList<>();
        Page page =PageHelper.startPage(search.getPage(),search.getLength());
        list=   this.sysUserMapper.selectEverywhere(search.getSearchValue(), search.getSearchRegex());
        response.setResult(list);
        response.setTotalCount(page.getTotal());
        return response;
    }
    @Override
    public int updateById(SysUser record) {
        return this.sysUserMapper.updateById(record);
    }
    @Override
    public int getByNameTotal(String username) {
        return this.sysUserMapper.getByNameTotal(username);
    }
    @Override
    public int insert(SysUser record) {
        return this.sysUserMapper.insert(record);
    }
    @Override
    public String getNameById(Integer id) {
        return this.sysUserMapper.selectNameById(id);
    }
    @Override
    public int getByNameTotals(String username, Integer userId) {
        Map map = new HashMap();
        map.put("username", username);
        map.put("userId", userId);
        return this.sysUserMapper.getByNameTotals(map).intValue();
    }
}
