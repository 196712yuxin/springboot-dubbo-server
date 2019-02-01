package org.spring.springboot.base.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class BasePO
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long rowVersion;
    private Boolean isDeleted;
    private Long createdBy;
    private Timestamp creationTime;
    private Long lastUpdatedBy;
    private Timestamp lastUpdateTime;

    public Boolean getIsDeleted()
    {
        return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public Long getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy)
    {
        this.createdBy = createdBy;
    }

    public Timestamp getCreationTime()
    {
        return this.creationTime;
    }

    public void setCreationTime(Timestamp creationTime)
    {
        this.creationTime = creationTime;
    }

    public Long getLastUpdatedBy()
    {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy)
    {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Timestamp getLastUpdateTime()
    {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getRowVersion()
    {
        return this.rowVersion;
    }

    public void setRowVersion(Long rowVersion)
    {
        this.rowVersion = rowVersion;
    }
}

