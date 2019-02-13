package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.SysParameter;

@Mapper
public abstract interface SysParameterMapper
{
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysParameter paramSysParameter);

    public abstract int insertSelective(SysParameter paramSysParameter);

    public abstract SysParameter selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysParameter paramSysParameter);

    public abstract int updateByPrimaryKey(SysParameter paramSysParameter);
}