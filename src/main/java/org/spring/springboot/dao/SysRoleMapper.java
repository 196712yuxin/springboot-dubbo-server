package org.spring.springboot.dao;


import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.SysRole;
@Mapper
public abstract interface SysRoleMapper
{
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysRole paramSysRole);

    public abstract int insertSelective(SysRole paramSysRole);

    public abstract SysRole selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysRole paramSysRole);

    public abstract int updateByPrimaryKey(SysRole paramSysRole);
}
