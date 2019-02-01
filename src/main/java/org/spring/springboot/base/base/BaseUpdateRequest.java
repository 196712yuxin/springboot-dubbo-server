package org.spring.springboot.base.base;

public class BaseUpdateRequest
        extends BaseRequest
{
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
