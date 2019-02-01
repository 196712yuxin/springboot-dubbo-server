package org.spring.springboot.utils;


import com.alibaba.dubbo.common.utils.StringUtils;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class AESUtil
{
    public static String generate_key()
    {
        return "W($3%_w@";
    }

    public static String aes_encrypt(String password) {
        try {
            String strKey = generate_key();
            if (StringUtils.isBlank(strKey)) {
                return password;
            }
            byte[] keyBytes = Arrays.copyOf(strKey.getBytes("ASCII"), 16);

            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, key);

            byte[] cleartext = password.getBytes("UTF-8");
            byte[] ciphertextBytes = cipher.doFinal(cleartext);

            return new String(Hex.encodeHex(ciphertextBytes));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String aes_decrypt(String password) {
        try {
            String strKey = generate_key();
            byte[] keyBytes = Arrays.copyOf(strKey.getBytes("ASCII"), 16);

            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);

            byte[] cleartext = Hex.decodeHex(password.toCharArray());
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(ciphertextBytes, "UTF-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String aes_encrypt(String password, String strKey)
    {
        try {
            if (StringUtils.isBlank(strKey)) {
                return password;
            }
            byte[] keyBytes = Arrays.copyOf(strKey.getBytes("ASCII"), 16);

            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, key);

            byte[] cleartext = password.getBytes("UTF-8");
            byte[] ciphertextBytes = cipher.doFinal(cleartext);

            return new String(Hex.encodeHex(ciphertextBytes));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String aes_decrypt(String password, String strKey) {
        try {
            byte[] keyBytes = Arrays.copyOf(strKey.getBytes("ASCII"), 16);

            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);

            byte[] cleartext = Hex.decodeHex(password.toCharArray());
            byte[] ciphertextBytes = cipher.doFinal(cleartext);
            return new String(ciphertextBytes, "UTF-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String a = "M2aMkVn5sZaahSly";
        String b = "";
        b = aes_encrypt(a);
        System.out.println(b);
    }
}
