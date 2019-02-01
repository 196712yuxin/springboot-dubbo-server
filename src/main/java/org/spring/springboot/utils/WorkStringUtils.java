package org.spring.springboot.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WorkStringUtils
{
    public static final String DATE_TYPE_STR_SUFFIX = "String";

    public static boolean isEmpty(Object str)
    {
        return (str == null) || (str.toString().isEmpty()) || ("undefined".equals(str.toString()));
    }

    public static boolean isNotEmpty(Object str)
    {
        return !isEmpty(str);
    }

    public static String getEncoding(String str)
    {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception localException) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception localException1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception localException2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception localException3) {
        }
        encode = "BIG5";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s4 = encode;
                return s4;
            }
        } catch (Exception localException4) {
        }
        return "";
    }

    public static String encodeFileName(String fileName)
            throws Exception
    {
        return new String(fileName.getBytes(getEncoding(fileName)), "ISO-8859-1");
    }

    public static boolean isNotNum(String str)
    {
        if ((str == null) || ("".equals(str.trim()))) {
            return false;
        }
        Pattern pattern = Pattern.compile("[^0-9]+");
        Matcher isNum = pattern.matcher(str);

        return isNum.matches();
    }

    public static boolean isDecimal(String str)
    {
        if ((str == null) || ("".equals(str.trim()))) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
        Matcher isNum = pattern.matcher(str);

        return isNum.matches();
    }

    public static long getUUID2Long()
    {
        return UUID.randomUUID().getLeastSignificantBits() * -1L;
    }

    public static void formatNull(Object obj, String name)
    {
        try
        {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            if (null == field.get(obj)) {
                Method me = obj.getClass().getMethod("set" + name.toString().substring(0, 1).toUpperCase() + name.toString().substring(1), new Class[] { field.getType() });

                if (field.getGenericType().toString().indexOf("class") != -1)
                    if (field.getGenericType().toString().indexOf("Integer") != -1)
                        me.invoke(obj, new Object[] { Integer.valueOf(0) });
                    else if (field.getGenericType().toString().indexOf("String") != -1)
                    {
                        me.invoke(obj, new Object[] { "" });
                    } else if (field.getGenericType().toString().indexOf("Double") != -1)
                    {
                        me.invoke(obj, new Object[] { Double.valueOf(0.0D) });
                    }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidDate(String str, String style)
    {
        boolean convertSuccess = true;

        String formatDate = "";
        if (style.equals("0"))
            formatDate = "yyyy/MM/dd";
        else {
            formatDate = "yyyy-MM-dd";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatDate);

        format.setLenient(false);
        try {
            format.parse(str);
        }
        catch (ParseException e)
        {
            convertSuccess = false;
        }

        return convertSuccess;
    }

    public static Date formateTime(String time)
    {
        Date datefor = null;
        String formatDate = "";
        if ((time != null) && (time.indexOf("-") > 0)) {
            formatDate = "yyyy-MM-dd";
        }
        else {
            formatDate = "yyyy/MM/dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        try {
            datefor = sdf.parse(time);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return datefor;
    }

    public static Date formateTimeMin(String time)
    {
        Date datefor = null;
        String formatDate = "";

        if ((time != null) && (time.indexOf("-") > 0)) {
            if (time.length() < 16)
            {
                time = time + " 00:00:00";
            }
            formatDate = "yyyy-MM-dd HH:mm:ss";
        }
        else {
            if (time.length() < 16)
            {
                time = time + " 00:00:00";
            }
            formatDate = "yyyy/MM/dd HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        try {
            datefor = sdf.parse(time);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return datefor;
    }

    public static int formateInt(String num)
    {
        if ((num != null) && (num.indexOf(".") > 0)) {
            double format = Double.parseDouble(num);
            int formatint = (int)format;
            return formatint;
        }
        return Integer.parseInt(num);
    }

    public static int formatetoInt(String num)
    {
        int a = 0;
        try {
            a = Integer.parseInt(num);
        }
        catch (Exception e) {
            return a;
        }
        return a;
    }

    public static String dealDateType(String dateString)
    {
        if ((dateString != null) && (dateString.endsWith("String"))) {
            return dateString.substring(0, dateString.lastIndexOf("String"));
        }

        return dateString;
    }

    public static Date dateToStringType(Date dateString, String wei)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(dateString);
        if ((wei != null) && (wei.length() >= 7)) {
            if (wei.length() == 7)
                str = str + " 0" + wei;
            else {
                str = str + " " + wei;
            }
            dateString = formateTimeMin(str);
        }

        return dateString;
    }

    public static int formatemoney(String num)
    {
        int money = 0;
        try {
            money = formateInt(num);
        } catch (NumberFormatException e) {
            try {
                if ((num != null) && (!"".equals(num)) && (num.length() >= 2)) {
                    String numStyle = num.substring(num.length() - 1, num.length());

                    if (numStyle.equals("十")) {
                        String c = num.substring(0, num.length() - 1);
                        money = formateInt(c) * 10;
                    }

                    if (numStyle.equals("百")) {
                        String c = num.substring(0, num.length() - 1);
                        money = formateInt(c) * 100;
                    }

                    if (numStyle.equals("千")) {
                        String c = num.substring(0, num.length() - 1);
                        money = formateInt(c) * 1000;
                    }

                    if (numStyle.equals("万")) {
                        String c = num.substring(0, num.length() - 1);
                        money = formateInt(c) * 10000;
                    }
                }
            }
            catch (NumberFormatException ex) {
                money = 0;
            }
        }

        System.out.println(money);
        return money;
    }

    public static boolean regExpPd(String pd) {
        Pattern p = Pattern.compile("^(?![^a-zA-Z]+$)(?!\\D+$).{8,15}$");
        Matcher m = p.matcher(pd);
        boolean flg = m.matches();
        return flg;
    }

    public static Date yesterdayStart()
    {
        long yesterday = System.currentTimeMillis() - 86400000L;
        long zero = yesterday / 86400000L * 86400000L - TimeZone.getDefault().getRawOffset();

        Date start = new Date(zero);
        return start;
    }

    public static Date yesterdayEnd()
    {
        long yesterday = System.currentTimeMillis() - 86400000L;
        long zero = yesterday / 86400000L * 86400000L - TimeZone.getDefault().getRawOffset();

        zero = zero + 86400000L - 1L;
        Date end = new Date(zero);
        return end;
    }

    public static Date getCreateIndexDate(Date time, String index) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formater.format(time);

        String doDate = strDate.substring(0, 11) + index;
        Date firstDate = null;
        try
        {
            firstDate = formater.parse(doDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return firstDate;
    }

    public static Date addHour(Date time, int hour)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int day = calendar.get(10);
        calendar.set(10, day + hour);
        Date datechange = calendar.getTime();

        return datechange;
    }

    public static Date addDay(Date time, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int day = calendar.get(5);
        calendar.set(5, day + i);
        Date datechange = calendar.getTime();

        return datechange;
    }

    public static long getDatePoor(Date endDate, Date nowDate)
    {
        long nd = 86400000L;
        long nh = 3600000L;
        long nm = 60000L;

        long diff = endDate.getTime() - nowDate.getTime();
        long day = diff % nd / nh;

        return day;
    }

    public static boolean isworkday(Date time)
    {
        boolean tip = false;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = formater.format(time);

        String doDate = strDate.substring(0, 11) + "08:30:00";
        Date startDate = null;
        try
        {
            startDate = formater.parse(doDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        Date endDate = null;

        String enddoDate = strDate.substring(0, 11) + "17:30:00";
        try {
            endDate = formater.parse(enddoDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        if ((time.after(startDate)) && (time.before(endDate)))
        {
            tip = true;
        }

        return tip;
    }

    public static void main(String[] args)
    {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        String strDate = formater.format(time);
        String doDate = strDate.substring(0, 11) + "8:30:00";
        Date startDate = null;
        try
        {
            startDate = formater.parse(doDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        boolean tip = isworkday(startDate);

        System.out.println(tip);
    }
}
