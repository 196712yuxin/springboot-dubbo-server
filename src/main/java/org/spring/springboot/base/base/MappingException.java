package org.spring.springboot.base.base;


public class MappingException
        extends RuntimeException
{
    public MappingException(String message)
    {
        super(message);
    }

    public MappingException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public MappingException(Throwable message)
    {
        super(message);
    }
}
