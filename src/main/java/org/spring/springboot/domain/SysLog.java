package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

import java.util.Date;

public class SysLog extends BaseDomain {
    private Integer id;
    private String operation;
    private Date operationtime;
    private Integer operationuserid;
    private String ip;
    private String logcontent;
    private Integer createduserid;
    private Date createddate;

    public Integer getId() {
        return this.id;
    }

    public String getOperation() {
        return this.operation;
    }

    public Date getOperationtime() {
        return this.operationtime;
    }

    public Integer getOperationuserid() {
        return this.operationuserid;
    }

    public String getIp() {
        return this.ip;
    }

    public String getLogcontent() {
        return this.logcontent;
    }

    public Integer getCreateduserid() {
        return this.createduserid;
    }

    public Date getCreateddate() {
        return this.createddate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public void setOperationuserid(Integer operationuserid) {
        this.operationuserid = operationuserid;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLogcontent(String logcontent) {
        this.logcontent = logcontent;
    }

    public void setCreateduserid(Integer createduserid) {
        this.createduserid = createduserid;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }



    public String toString() {
        return "SysLog(id=" + getId() + ", operation=" + getOperation() + ", operationtime=" + getOperationtime() + ", operationuserid=" + getOperationuserid() + ", ip=" + getIp() + ", logcontent=" + getLogcontent() + ", createduserid=" + getCreateduserid() + ", createddate=" + getCreateddate() + ")";
    }
}
