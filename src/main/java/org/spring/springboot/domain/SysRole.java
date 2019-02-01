package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

import java.util.Date;

public class SysRole extends BaseDomain {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private String roleCode;
    private String isActive;
    private Integer createdBy;
    private Date createdTime;
    private Integer lastUpdatedBy;
    private Date lastUpdatedTime;

    public Integer getId() {
        return this.id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }

    public String getRoleCode() {
        return this.roleCode;
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

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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
        return "SysRole(id=" + getId() + ", roleName=" + getRoleName() + ", roleDesc=" + getRoleDesc() + ", roleCode=" + getRoleCode() + ", isActive=" + getIsActive() + ", createdBy=" + getCreatedBy() + ", createdTime=" + getCreatedTime() + ", lastUpdatedBy=" + getLastUpdatedBy() + ", lastUpdatedTime=" + getLastUpdatedTime() + ")";
    }
}
