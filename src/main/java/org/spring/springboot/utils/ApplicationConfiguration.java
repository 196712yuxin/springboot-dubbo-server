package org.spring.springboot.utils;

public class ApplicationConfiguration
{
    public static final String APPLICATION_TITLE = ParsProperFile.getApplicationProp("applicationTitle");
    public static final String SESSIOIN_KEY_CURRENT_USER = "currentUser";
    public static final String REQUEST_KEY_CURRENT_URL = "currenturl";
    public static final String COOKIE_USER = ParsProperFile.getApplicationProp("cookieUser");
    public static final String COOKIE_MP = ParsProperFile.getApplicationProp("cookieMp");
    public static final int COOKIE_MAX_AGE = 3600;
    public static final String ERROR_NEED_AUTHENTICATION = ParsProperFile.getApplicationProp("cookiePassword");
    public static final String ERROR_NEED_PRIVILLEGE = ParsProperFile.getApplicationProp("errorNeedPrivillege");
    public static final String DOWNLOADPATH = ParsProperFile.getApplicationProp("downloadpath");
    public static final String COOKIE_SINGLESIGNIN = ParsProperFile.getApplicationProp("cookieSingleSignin");
}
