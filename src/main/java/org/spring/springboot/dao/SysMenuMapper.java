package org.spring.springboot.dao;



import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.SysMenu;

import java.util.List;

@Mapper
public abstract interface SysMenuMapper
{
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysMenu paramSysMenu);

    public abstract int insertSelective(SysMenu paramSysMenu);

    public abstract SysMenu selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysMenu paramSysMenu);

    public abstract int updateByPrimaryKey(SysMenu paramSysMenu);

    public abstract List<SysMenu> selectMenuByUserId(Integer paramInteger);

    public abstract List<SysMenu> getAllRootMenu();

    public abstract List<SysMenu> getFunctionByUserId(long paramLong);
}
