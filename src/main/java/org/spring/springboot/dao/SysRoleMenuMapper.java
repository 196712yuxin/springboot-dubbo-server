package org.spring.springboot.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.base.BaseMapper;
import org.spring.springboot.domain.SysRoleMenu;
import org.spring.springboot.response.SysRoleMenuResponse;

import java.util.List;

@Mapper
public abstract interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysRoleMenu paramSysRoleMenu);

    public abstract int insertSelective(SysRoleMenu paramSysRoleMenu);

    public abstract SysRoleMenu selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysRoleMenu paramSysRoleMenu);

    public abstract int updateByPrimaryKey(SysRoleMenu paramSysRoleMenu);

    public abstract int hasPrivilleges(@Param("userid") Integer paramInteger, @Param("pageurl") String paramString);

    public abstract List<SysRoleMenuResponse> selectEverywhereId(@Param("searchValue") String paramString1, @Param("searchRegex") String paramString2);

}
