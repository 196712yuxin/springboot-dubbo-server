package org.spring.springboot.dubbo;



import org.spring.springboot.domain.ErrorStatus;
import org.spring.springboot.domain.PagerQuery;
import org.spring.springboot.domain.SysUser;
import org.spring.springboot.response.SysUserFindResponse;

import java.util.List;
import java.util.Map;

public interface SysUserService
{
    public SysUser selectByPrimaryKey(Integer id);
    public Map<String, Object> login(String username, String password, String ip, ErrorStatus errorStatus);
    public SysUserFindResponse selectEverywhere(PagerQuery<SysUser> search);
    public int updateById(SysUser record);
    public int getByNameTotal(String username);
    public int insert(SysUser record);
    public String getNameById(Integer id);
    public int getByNameTotals(String username, Integer userId);

}
