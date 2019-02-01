package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

public class PagerQuery<T>  extends BaseDomain {
    private T search;
    private Integer start;
    private Integer length;
    private String orderColumn;
    private String orderDir;
    private String searchValue;
    private String searchRegex;

    public Integer getPage() {
        return Integer.valueOf(this.start.intValue() / this.length.intValue() + 1);
    }

    public T getSearch() {
        return this.search;
    }

    public void setSearch(T search) {
        this.search = search;
    }

    public Integer getStart() {
        return this.start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return this.length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getOrderColumn() {
        return this.orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDir() {
        return this.orderDir;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }

    public String getSearchValue() {
        return this.searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSearchRegex() {
        return this.searchRegex;
    }

    public void setSearchRegex(String searchRegex) {
        this.searchRegex = searchRegex;
    }



    public String toString() {
        return "PagerQuery(search=" + getSearch() + ", start=" + getStart() + ", length=" + getLength() + ", orderColumn=" + getOrderColumn() + ", orderDir=" + getOrderDir() + ", searchValue=" + getSearchValue() + ", searchRegex=" + getSearchRegex() + ")";
    }
}
