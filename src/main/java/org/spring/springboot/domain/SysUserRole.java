package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

import java.util.Date;

public class SysUserRole extends BaseDomain {
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private String isActive;
    private Integer createdBy;
    private Date createdTime;
    private Integer lastUpdatedBy;
    private Date lastUpdatedTime;

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public Integer getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public Date getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }



    public String toString() {
        return "SysUserRole(id=" + getId() + ", userId=" + getUserId() + ", roleId=" + getRoleId() + ", isActive=" + getIsActive() + ", createdBy=" + getCreatedBy() + ", createdTime=" + getCreatedTime() + ", lastUpdatedBy=" + getLastUpdatedBy() + ", lastUpdatedTime=" + getLastUpdatedTime() + ")";
    }
}
