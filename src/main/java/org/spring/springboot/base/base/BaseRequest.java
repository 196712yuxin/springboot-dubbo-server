package org.spring.springboot.base.base;

import java.io.Serializable;

public class BaseRequest
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long requestIndex;

    public Long getRequestIndex()
    {
        return this.requestIndex;
    }

    public void setRequestIndex(Long requestIndex)
    {
        this.requestIndex = requestIndex;
    }
}
