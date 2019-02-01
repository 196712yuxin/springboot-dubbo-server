package org.spring.springboot.annotaction;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrivilegeSupport
{
    public abstract boolean support();
}