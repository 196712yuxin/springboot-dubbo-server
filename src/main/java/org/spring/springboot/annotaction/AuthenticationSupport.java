package org.spring.springboot.annotaction;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthenticationSupport
{
    public abstract boolean support();
}
