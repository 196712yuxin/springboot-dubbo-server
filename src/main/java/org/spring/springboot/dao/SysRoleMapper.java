package org.spring.springboot.dao;


import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.base.BaseMapper;
import org.spring.springboot.domain.SysMenu;
import org.spring.springboot.domain.SysRole;

import java.util.List;

@Mapper
public abstract interface SysRoleMapper extends BaseMapper<SysRole> {
    public abstract int deleteByPrimaryKey(Integer paramInteger);

    public abstract int insert(SysRole paramSysRole);

    public abstract int insertSelective(SysRole paramSysRole);

    public abstract SysRole selectByPrimaryKey(Integer paramInteger);

    public abstract int updateByPrimaryKeySelective(SysRole paramSysRole);

    public abstract int updateByPrimaryKey(SysRole paramSysRole);

    public abstract List<SysRole> getAllRolt();

    public abstract int getMaxId();
}
