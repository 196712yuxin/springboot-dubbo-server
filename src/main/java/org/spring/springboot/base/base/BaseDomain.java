package org.spring.springboot.base.base;

import java.io.Serializable;

public class BaseDomain
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long rowVersion;

    public Long getRowVersion()
    {
        return this.rowVersion;
    }

    public void setRowVersion(Long rowVersion)
    {
        this.rowVersion = rowVersion;
    }
}
