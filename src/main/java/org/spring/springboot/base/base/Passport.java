package org.spring.springboot.base.base;

import java.io.Serializable;
import java.util.Date;

public class Passport extends BasePO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private Long tenantId;
    /** @deprecated */
    @Deprecated
    private Long tenantNumber;
    /** @deprecated */
    @Deprecated
    private String tenantName;
    /** @deprecated */
    @Deprecated
    private String logo;
    /** @deprecated */
    @Deprecated
    private Long adminId;
    /** @deprecated */
    @Deprecated
    private Long ownerId;
    private Long userId;
    private String userName;
    private Long unionId;
    private String nickName;
    /** @deprecated */
    @Deprecated
    private String avatar;
    /** @deprecated */
    @Deprecated
    private Long employeeId;
    /** @deprecated */
    @Deprecated
    private String employeeNumber;
    /** @deprecated */
    @Deprecated
    private String photo;
    private Date issueTime;
    private Date expireTime;
    private Date revokeTime;
    private String revokeType;
    private String issueIP;
    private Long issueClient;
    private PassportTypeEnum type;
    /** @deprecated */
    @Deprecated
    private String ati;
    /** @deprecated */
    @Deprecated
    private String url;
    /** @deprecated */
    @Deprecated
    private String userAccount;
    private LanguageEnum language;

    public Passport() {
    }

    /** @deprecated */
    @Deprecated
    public String getLogo() {
        return this.logo;
    }

    /** @deprecated */
    @Deprecated
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /** @deprecated */
    @Deprecated
    public String getAvatar() {
        return this.avatar;
    }

    /** @deprecated */
    @Deprecated
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /** @deprecated */
    @Deprecated
    public String getPhoto() {
        return this.photo;
    }

    /** @deprecated */
    @Deprecated
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getRevokeTime() {
        return this.revokeTime;
    }

    public void setRevokeTime(Date revokeTime) {
        this.revokeTime = revokeTime;
    }

    public String getRevokeType() {
        return this.revokeType;
    }

    public void setRevokeType(String revokeType) {
        this.revokeType = revokeType;
    }

    public String getIssueIP() {
        return this.issueIP;
    }

    public void setIssueIP(String issueIP) {
        this.issueIP = issueIP;
    }

    public Long getIssueClient() {
        return this.issueClient;
    }

    public void setIssueClient(Long issueClient) {
        this.issueClient = issueClient;
    }

    /** @deprecated */
    @Deprecated
    public Long getTenantNumber() {
        return this.tenantNumber;
    }

    /** @deprecated */
    @Deprecated
    public void setTenantNumber(Long tenantNumber) {
        this.tenantNumber = tenantNumber;
    }

    /** @deprecated */
    @Deprecated
    public String getTenantName() {
        return this.tenantName;
    }

    /** @deprecated */
    @Deprecated
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /** @deprecated */
    @Deprecated
    public Long getEmployeeId() {
        return this.employeeId;
    }

    /** @deprecated */
    @Deprecated
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /** @deprecated */
    @Deprecated
    public String getEmployeeNumber() {
        return this.employeeNumber;
    }

    /** @deprecated */
    @Deprecated
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /** @deprecated */
    @Deprecated
    public Long getOwnerId() {
        return this.ownerId;
    }

    /** @deprecated */
    @Deprecated
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /** @deprecated */
    @Deprecated
    public Long getAdminId() {
        return this.adminId;
    }

    /** @deprecated */
    @Deprecated
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public PassportTypeEnum getType() {
        return this.type;
    }

    public void setType(PassportTypeEnum type) {
        this.type = type;
    }

    /** @deprecated */
    @Deprecated
    public String getAti() {
        return this.ati;
    }

    /** @deprecated */
    @Deprecated
    public void setAti(String ati) {
        this.ati = ati;
    }

    /** @deprecated */
    @Deprecated
    public String getUrl() {
        return this.url;
    }

    /** @deprecated */
    @Deprecated
    public void setUrl(String url) {
        this.url = url;
    }

    /** @deprecated */
    @Deprecated
    public String getUserAccount() {
        return this.userAccount;
    }

    /** @deprecated */
    @Deprecated
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Long getUnionId() {
        return this.unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }

    public LanguageEnum getLanguage() {
        return this.language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }
}
