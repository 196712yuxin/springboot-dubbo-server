package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

import java.util.Date;

public class SysUser extends BaseDomain {
    private Integer id;
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String cellphone;
    private Date lastLoginTime;
    private String lastLoginIp;
    private Integer loginErrCount;
    private String isLocked;
    private String isActive;
    private String address;
    private String jobnum;
    private String ipphone;
    private Integer gender;
    private Integer createdBy;
    private Date createdTime;
    private Integer lastUpdatedBy;
    private Date lastUpdatedTime;
    private Date pwdexpiredate;
    private String openId;
    private String wcode;

    public String getIsLocked() {
        return this.isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return this.lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getLoginErrCount() {
        return this.loginErrCount;
    }

    public void setLoginErrCount(Integer loginErrCount) {
        this.loginErrCount = loginErrCount;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobnum() {
        return this.jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getIpphone() {
        return this.ipphone;
    }

    public void setIpphone(String ipphone) {
        this.ipphone = ipphone;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Date getPwdexpiredate() {
        return this.pwdexpiredate;
    }

    public void setPwdexpiredate(Date pwdexpiredate) {
        this.pwdexpiredate = pwdexpiredate;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWcode() {
        return this.wcode;
    }

    public void setWcode(String wcode) {
        this.wcode = wcode;
    }


    public String toString() {
        return "SysUser(id=" + getId() + ", username=" + getUsername() + ", password=" + getPassword() + ", displayName=" + getDisplayName() + ", email=" + getEmail() + ", cellphone=" + getCellphone() + ", lastLoginTime=" + getLastLoginTime() + ", lastLoginIp=" + getLastLoginIp() + ", loginErrCount=" + getLoginErrCount() + ", isLocked=" + getIsLocked() + ", isActive=" + getIsActive() + ", address=" + getAddress() + ", jobnum=" + getJobnum() + ", ipphone=" + getIpphone() + ", gender=" + getGender() + ", createdBy=" + getCreatedBy() + ", createdTime=" + getCreatedTime() + ", lastUpdatedBy=" + getLastUpdatedBy() + ", lastUpdatedTime=" + getLastUpdatedTime() + ", pwdexpiredate=" + getPwdexpiredate() + ", openId=" + getOpenId() + ", wcode=" + getWcode() + ")";
    }
}
