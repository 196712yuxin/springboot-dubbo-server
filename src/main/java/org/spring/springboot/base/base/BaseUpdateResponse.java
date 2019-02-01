package org.spring.springboot.base.base;

public class BaseUpdateResponse
        extends BaseResponse
{
    private Long result;

    public Long getResult()
    {
        return this.result;
    }

    public void setResult(Long result)
    {
        this.result = result;
    }
}
