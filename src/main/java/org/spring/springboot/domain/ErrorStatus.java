package org.spring.springboot.domain;

import org.spring.springboot.base.base.BaseDomain;

public class ErrorStatus extends BaseDomain
{
    private int errorCode;
    private String errorMessage;

    public int getErrorCode()
    {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
