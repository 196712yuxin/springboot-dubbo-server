package org.spring.springboot.base.base;



public class BaseFindRequest<T extends Enum<T>>
        extends BaseRequest
{
    private int pageNumber = 1;
    private int pageSize = 10;
    private Enum<T> sortKey;
    private SortTypeEnum sortType;

    public SortTypeEnum getSortType()
    {
        return this.sortType;
    }

    public void setSortType(SortTypeEnum sortType)
    {
        this.sortType = sortType;
    }

    public Enum<T> getSortKey()
    {
        return this.sortKey;
    }

    public void setSortKey(Enum<T> sortKey)
    {
        this.sortKey = sortKey;
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getPageNumber()
    {
        if (this.pageNumber <= 0) {
            return 1;
        }
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    public int getBeginItemIndex()
    {
        return (getPageNumber() - 1) * getPageSize();
    }

    public int getEndItemIndex()
    {
        return getPageNumber() * getPageSize();
    }
}
