package org.spring.springboot.base.base;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FoundationService
{
    private static final int LENGTH = 8;

    public static String genImageName()
    {
        long millis = System.currentTimeMillis();

        Random random = new Random();
        int end3 = random.nextInt(999);

        String str = millis + String.format("%03d", new Object[] { Integer.valueOf(end3) });
        return str;
    }

    public static long genItemId()
    {
        long millis = System.currentTimeMillis();

        Random random = new Random();
        int end2 = random.nextInt(99);

        String str = millis + String.format("%02d", new Object[] { Integer.valueOf(end2) });
        long id = new Long(str).longValue();
        return id;
    }

    public static int getRandNum(int min, int max)
    {
        int randNum = min + (int)(Math.random() * (max - min + 1));
        return randNum;
    }

    public static long orderId()
    {
        int r1 = (int)(Math.random() * 9.0D + 1.0D);
        int r2 = (int)(Math.random() * 10.0D);
        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyMMddHHmmss");
        String format = yyyyMMddHHmmss.format(new Date());
        return Long.parseLong(format + r1 + r2);
    }

    public static String genRandomNum(int pwd_len)
    {
        int maxNum = 36;

        int count = 0;
        char[] str = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len)
        {
            int i = Math.abs(r.nextInt(36));
            if ((i >= 0) && (i < str.length))
            {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }

    public static String generateNumber()
    {
        String no = "";

        int[] defaultNums = new int[10];
        for (int i = 0; i < defaultNums.length; i++) {
            defaultNums[i] = i;
        }
        Random random = new Random();
        int[] nums = new int[8];

        int canBeUsed = 10;
        for (int i = 0; i < nums.length; i++)
        {
            int index = random.nextInt(canBeUsed);
            nums[i] = defaultNums[index];

            swap(index, canBeUsed - 1, defaultNums);
            canBeUsed--;
        }
        if (nums.length > 0) {
            for (int i = 1; i < nums.length; i++) {
                no = no + nums[i];
            }
        }
        return no;
    }

    private static void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

