package com.dyx.bpls.util;

import java.util.regex.Pattern;

/**
 * project name：BlogProjectLoginScreen
 * class describe：
 * create person：dayongxin
 * create time：16/8/7 下午10:15
 * alter person：dayongxin
 * alter time：16/8/7 下午10:15
 * alter remark：
 */
public class ValidUtils {
    public static boolean isMobile(String phoneNum) {
        if (phoneNum == null)
            return false;
        return validation("^[1][3,4,5,7,8][0-9]{9}$",
                phoneNum.replace("+86", ""));
    }

    public static boolean isUserName(String username) {
        return validation("^[a-z0-9_-]{3,15}$", username);
    }

    public static boolean isPassword(String pwd) {
        return validation("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$", pwd);
    }

    public static boolean isEmail(String mail) {
        return validation(
                "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",
                mail);
    }

    public static boolean validation(String pattern, String str) {
        if (str == null)
            return false;
        return Pattern.compile(pattern).matcher(str).matches();
    }
}
