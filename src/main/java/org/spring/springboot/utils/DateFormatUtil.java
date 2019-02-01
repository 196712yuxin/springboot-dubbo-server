package org.spring.springboot.utils;



import com.alibaba.dubbo.common.utils.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil
{
    public static final String FORMATDATE = "yyyy-MM-dd";
    public static final String FORMATDATENUM = "yyyyMMdd";
    public static final String FORMATDATE2 = "yyyyMM";
    public static final String FORMATDATETIME = "yyyy-MM-dd HH:mm:ss";

    public static String format(Timestamp timestamp, String format)
    {
        if (timestamp == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(new Date(timestamp.getTime()));
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static Date parse(String date, String format) {
        if (date == null) {
            return null;
        }
        DateFormat fmt = new SimpleDateFormat(format);
        Date date2;
        try
        {
            date2 = fmt.parse(date);
        }
        catch (ParseException e)
        {
            return null;
        }

        return date2;
    }

    public static long diffDays(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = sdf.parse(sdf.format(date1));
            date2 = sdf.parse(sdf.format(date2));
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(date2);
            long time2 = cal.getTimeInMillis();
            long between_days = (time1 - time2) / 86400000L;
            return between_days;
        } catch (ParseException e) {
            e.printStackTrace();
        }return 0L;
    }

    public static String getBeforeDay(int day)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(5, -day);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }

    public static Date getAfterTime(int day)
    {
        Calendar c = Calendar.getInstance();
        c.add(5, day);
        Date date = c.getTime();
        return date;
    }

    public static String FormatDateStr(String oldDate)
    {
        if (null==oldDate||"".equals(oldDate)||StringUtils.isEmpty(oldDate)) {
            return "";
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");

        Date d = null;
        try {
            if ((oldDate.contains("年")) || (oldDate.contains("月")) || (oldDate.contains("日")))
                d = sdf1.parse(oldDate);
            else if (oldDate.contains("/"))
                d = sdf2.parse(oldDate);
            else
                return oldDate;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf3.format(d);
    }

    public static Date getMinDate(Date[] arr)
    {
        if ((arr == null) || (arr.length <= 0)) {
            return null;
        }
        Arrays.sort(arr);
        return arr[0];
    }

    public static Date getMaxDate(Date[] arr)
    {
        if ((arr == null) || (arr.length <= 0)) {
            return null;
        }
        Arrays.sort(arr);
        return arr[(arr.length - 1)];
    }

    public static String getSpecifiedDayBefore(String specifiedDay)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    public static String getSpecifiedDayAfter(String specifiedDay)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }
}
