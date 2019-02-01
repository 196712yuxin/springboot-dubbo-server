package org.spring.springboot.base.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface BaseMapper<T>
{
    public abstract int deleteById(Integer paramInteger);

    public abstract int deleteByIds(List<Integer> paramList);

    public abstract int deleteSoftByIds(List<Integer> paramList);

    public abstract int insert(T paramT);

    public abstract int insertSelective(T paramT);

    public abstract T selectById(Integer paramInteger);

    public abstract List<T> selectAll();

    public abstract List<T> select(T paramT);

    public abstract List<T> selectEverywhere(@Param("searchValue") String paramString1, @Param("searchRegex") String paramString2);

    public abstract boolean exist(T paramT);

    public abstract int updateByIdSelective(T paramT);

    public abstract int updateById(T paramT);

    public abstract int getByNameTotal(String paramString);

    public abstract List<T> selectAllFinacing(T paramT);
}
