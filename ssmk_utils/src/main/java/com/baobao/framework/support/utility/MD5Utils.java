package com.baobao.framework.support.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    private static String m_algorithm = "MD5";

    public static String encrypt(String str) {
        return encryption(str);
    }


    /**
     * @param sourceStr 明文
     * @return 32位密文
     */
    public static String encryption(String sourceStr) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance(m_algorithm);
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuilder builder = new StringBuilder("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    builder.append("0");
                builder.append(Integer.toHexString(i));
            }
            re_md5 = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
    
    public static void main(String args[]) {
    	System.out.println(encryption("aobaobei*()6"));

        System.out.print(encrypt("11111111"));
    }

}
