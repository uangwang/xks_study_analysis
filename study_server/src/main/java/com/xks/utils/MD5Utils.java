package com.xks.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {

    private static final String salt = "diamond";

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    public static String inputPassToFormPass(String inputPass) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = ""+salt.charAt(1)+salt.charAt(0) + formPass +salt.charAt(3) + salt.charAt(2);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB) {
        return formPassToDBPass(inputPassToFormPass(inputPass), saltDB);
    }

}

