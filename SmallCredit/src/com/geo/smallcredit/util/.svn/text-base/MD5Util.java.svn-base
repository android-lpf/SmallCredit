package com.geo.smallcredit.util;

import java.security.MessageDigest;

/** 
 * 閲囩敤MD5鍔犲瘑瑙ｅ瘑 
 * @author Allen
 * @date 02/04/2015 16:32:02
 */  
public class MD5Util {  
  
    /*** 
     * MD5鍔犵爜 鐢熸垚32浣峬d5锟�
     */  
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = (md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }  
  
    /** 
     * 鍔犲瘑瑙ｅ瘑绠楁硶 鎵ц锟�锟斤拷鍔犲瘑锛屼袱娆¤В锟�
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
    // 娴嬭瘯涓诲嚱锟� 
    public static void main(String args[]) {  
        String s = new String("test");  
        System.out.println("鍘熷瀵嗙爜锛� "+ s);
        System.out.println("MD5鍚庯細" + string2MD5(s));  
        System.out.println("鍔犲瘑鐨勶細" + convertMD5(s));  
        System.out.println("瑙ｅ瘑鐨勶細" + convertMD5(convertMD5(s)));  
  
    }  
}  