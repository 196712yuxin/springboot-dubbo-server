package org.spring.springboot.base.base;


public class BaseSearchRequest<T extends Enum<T>>
        extends BaseFindRequest<T>
{
    private static final long serialVersionUID = 1L;
    private String keyword;

    public String getKeyword()
    {
        return this.keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
}
