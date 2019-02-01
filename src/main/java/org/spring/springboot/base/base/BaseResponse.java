package org.spring.springboot.base.base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseResponse
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<Error> errors;

    public void addError(String code, String message)
    {
        Error error = new Error(code, message);
        try
        {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            error.setClazz(ste.getClassName());
            error.setMethod(ste.getMethodName());
            error.setLineNumber(ste.getLineNumber());
        }
        catch (Exception localException) {}
        _getErrors().add(error);
    }

    public void addError(ErrorType type, String message)
    {
        Error error = new Error(type, message);
        try
        {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            error.setClazz(ste.getClassName());
            error.setMethod(ste.getMethodName());
            error.setLineNumber(ste.getLineNumber());
        }
        catch (Exception localException) {}
        _getErrors().add(error);
    }

    public void addError(Error error)
    {
        _getErrors().add(error);
    }

    public void addErrors(List<Error> errors)
    {
        for (Error error : errors) {
            addError(error);
        }
    }

    public List<Error> getErrors()
    {
        return new ArrayList(_getErrors());
    }

    public String getFirstErrorMessage()
    {
        if (hasError()) {
            return ((Error)getErrors().get(0)).getMessage();
        }
        return "";
    }

    public boolean hasError()
    {
        return (this.errors != null) && (!this.errors.isEmpty());
    }

    private List<Error> _getErrors()
    {
        if (this.errors == null) {
            this.errors = new ArrayList();
        }
        return this.errors;
    }
}

