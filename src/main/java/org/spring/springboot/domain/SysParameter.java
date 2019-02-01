package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

import java.util.Date;

public class SysParameter extends BaseDomain {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private String paramvalue;
    private String paramvalue1;
    private String paramvalue2;
    private Integer parentId;
    private Integer createduserid;
    private Date createddate;
    private Integer lastmodifieduserid;
    private Date lastmodifieddate;
    private String isActive;

    public Integer getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getParamvalue() {
        return this.paramvalue;
    }

    public String getParamvalue1() {
        return this.paramvalue1;
    }

    public String getParamvalue2() {
        return this.paramvalue2;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public Integer getCreateduserid() {
        return this.createduserid;
    }

    public Date getCreateddate() {
        return this.createddate;
    }

    public Integer getLastmodifieduserid() {
        return this.lastmodifieduserid;
    }

    public Date getLastmodifieddate() {
        return this.lastmodifieddate;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue;
    }

    public void setParamvalue1(String paramvalue1) {
        this.paramvalue1 = paramvalue1;
    }

    public void setParamvalue2(String paramvalue2) {
        this.paramvalue2 = paramvalue2;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setCreateduserid(Integer createduserid) {
        this.createduserid = createduserid;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public void setLastmodifieduserid(Integer lastmodifieduserid) {
        this.lastmodifieduserid = lastmodifieduserid;
    }

    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }


    public String toString() {
        return "SysParameter(id=" + getId() + ", code=" + getCode() + ", name=" + getName() + ", description=" + getDescription() + ", paramvalue=" + getParamvalue() + ", paramvalue1=" + getParamvalue1() + ", paramvalue2=" + getParamvalue2() + ", parentId=" + getParentId() + ", createduserid=" + getCreateduserid() + ", createddate=" + getCreateddate() + ", lastmodifieduserid=" + getLastmodifieduserid() + ", lastmodifieddate=" + getLastmodifieddate() + ", isActive=" + getIsActive() + ")";
    }
}
