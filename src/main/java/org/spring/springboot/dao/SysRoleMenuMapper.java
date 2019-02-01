package org.spring.springboot.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.SysRoleMenu;

@Mapper
public abstract interface SysRoleMenuMapper {
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysRoleMenu paramSysRoleMenu);

    public abstract int insertSelective(SysRoleMenu paramSysRoleMenu);

    public abstract SysRoleMenu selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysRoleMenu paramSysRoleMenu);

    public abstract int updateByPrimaryKey(SysRoleMenu paramSysRoleMenu);

    public abstract int hasPrivilleges(@Param("userid") Integer paramInteger, @Param("pageurl") String paramString);
}
