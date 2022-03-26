package com.example.cugbacmpractice.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * MD5工具类，所有存入的密码都需要加密！  MD5 无法解密，只需要检查加密后和 MD5 是否一致即可。
 * @author 光球层上的黑子
 * */
@Slf4j
@Component
public class MD5Utils {
    /**
     * 盐值
     * */
    private static String salt="CUGB19级服务外包竞赛项目，author：曹胜华，王梓健，郎文鹏";

    public static String doEncryption(String inStr){
        return doMD5(doMD5(convertXOR(inStr)));
    }


    /**
     * MD5加密 生成32位md5码
     * @param inStr 待加密字符串
     * @return 加密后字符串
     */
    public static String doMD5(String inStr) {
        inStr+=salt;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            log.info(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 异或加密
     */
    public static String convertXOR(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    /**
     * 判断输入的未加密字符串和md5字符串是否一致
     * @param inStr 原字符串
     * @param MD5Str 数据库保存的密码
     * @return bool变量表示是否相等
     */
    public static boolean isSameString(String inStr,String MD5Str) {
        return MD5Str.equals(doEncryption(inStr));
    }
}