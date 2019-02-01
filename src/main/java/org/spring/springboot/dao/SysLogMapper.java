package org.spring.springboot.dao;


import org.spring.springboot.domain.SysLog;

public abstract interface SysLogMapper
{
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysLog paramSysLog);

    public abstract int insertSelective(SysLog paramSysLog);

    public abstract SysLog selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysLog paramSysLog);

    public abstract int updateByPrimaryKey(SysLog paramSysLog);
}