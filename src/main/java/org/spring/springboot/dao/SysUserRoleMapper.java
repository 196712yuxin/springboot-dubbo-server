package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.SysUserRole;
@Mapper
public abstract interface SysUserRoleMapper
{
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysUserRole paramSysUserRole);

    public abstract int insertSelective(SysUserRole paramSysUserRole);

    public abstract SysUserRole selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysUserRole paramSysUserRole);

    public abstract int updateByPrimaryKey(SysUserRole paramSysUserRole);
}
