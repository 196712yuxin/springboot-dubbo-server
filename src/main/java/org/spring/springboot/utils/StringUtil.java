package org.spring.springboot.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class StringUtil
{
    public static final String EMPTY_STRING = "";

    public static String getUUID()
    {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    public static String format(Date date, String dateFormat)
    {
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat(dateFormat).format(date);
    }

    public static boolean isEmpty(Object str)
    {
        return (str == null) || (str.toString().isEmpty());
    }

    public static boolean isNotEmpty(Object str)
    {
        return !isEmpty(str);
    }

    public static String getRandomPwd()
    {
        return UidUtil.getUIdForSequ();
    }

    public static String changeValue(Double value)
    {
        try
        {
            DecimalFormat df = new DecimalFormat("#.##");
            return df.format(value);
        }
        catch (Exception localException) {
        }
        return "0.00";
    }

    public static String paramIsEmpty(Object str, String name)
    {
        return isEmpty(str) ? "参数" + name + "不能为空" : null;
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}