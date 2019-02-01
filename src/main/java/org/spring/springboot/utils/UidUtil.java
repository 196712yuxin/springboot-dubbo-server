package org.spring.springboot.utils;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.UUID;

public final class UidUtil
{
    public static String getUIdForSequ()
    {
        long randomId = (long)(Math.random() * 1000.0D) * 100000000000L;

        return getUidString(randomId);
    }

    public static String getUidString(long l)
    {
        char[] buff = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        long tmp = Math.abs(l);
        StringBuffer sb = new StringBuffer();
        while (tmp > 0L)
        {
            int t = (int)(tmp % 62L);
            tmp /= 62L;
            sb.append(buff[t]);
        }

        return sb.reverse().toString();
    }

    public long getLong(String id)
    {
        char[] buff = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String indexes = new String(buff);
        long tmp = 0L;
        StringBuffer sb = new StringBuffer(id);
        sb.reverse();

        for (int i = 0; i < sb.length(); i++)
        {
            int index = indexes.indexOf(sb.charAt(i));
            tmp += index * Math.pow(62.0D, i);
        }

        return tmp;
    }

    public static String generateOrderNo() {
        return DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS") + UUID.randomUUID().toString().substring(30);
    }
}
