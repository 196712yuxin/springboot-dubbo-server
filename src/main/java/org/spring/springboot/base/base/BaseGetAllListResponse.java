package org.spring.springboot.base.base;



import java.util.List;

public class BaseGetAllListResponse<T>
        extends BaseResponse
{
    private long totalCount;
    private List<T> result;

    public List<T> getResult()
    {
        return this.result;
    }

    public void setResult(List<T> result)
    {
        this.result = result;
    }

    public long getTotalCount()
    {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }
}
