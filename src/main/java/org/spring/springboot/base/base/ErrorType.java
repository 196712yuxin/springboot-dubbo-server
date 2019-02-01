package org.spring.springboot.base.base;


public enum ErrorType
{
    UNIQUENESS_ERROR,  EXPECTATION_NULL,  BUSINESS_ERROR,  SYSTEM_ERROR,  INVALID_PARAMETER,  OTHER,  STACK_DUMP;

    private ErrorType() {}
}
