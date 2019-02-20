package org.spring.springboot.base.base;

import java.io.Serializable;

public class BaseDomain
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long rowVersion;
    private Boolean is_delete;

    public Boolean getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Boolean is_delete) {
        this.is_delete = is_delete;
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
