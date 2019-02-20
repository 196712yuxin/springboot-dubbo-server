package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.base.BaseMapper;
import org.spring.springboot.domain.SysUser;

import java.util.Map;

@Mapper
public abstract interface SysUserMapper extends BaseMapper<SysUser> {
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysUser paramSysUser);

    public abstract int insertSelective(SysUser paramSysUser);

    public abstract SysUser selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysUser paramSysUser);

    public abstract int updateByPrimaryKey(SysUser paramSysUser);

    public abstract void getUserByUsernameAndPassword(Map<String, Object> paramMap);

    public abstract String selectNameById(Integer paramInteger);

    public abstract Integer getByNameTotals(Map paramMap);

    public abstract Integer getBigId();
}
