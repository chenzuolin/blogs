package com.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    public static String code (String str){
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String sale = "chenzuolin";
            String password = str + sale;
            md5.update(password.getBytes());
            byte[] digest = md5.digest(password.getBytes());
            for (byte by : digest){
                String row = Integer.toHexString(by & 0xff);
                if(row.length()==1){
                    row = "0" + row;
                }
                sb.append(row);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
