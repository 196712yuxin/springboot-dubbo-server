package org.spring.springboot.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ParsProperFile
{
    private static ResourceBundle appProcBud = ResourceBundle.getBundle("application");

    public static String getApplicationProp(String key)
    {
        try
        {
            return appProcBud.getString(key); } catch (MissingResourceException e) {
        }
        return null;
    }
}
