package com.kfit.spring_boot_mybatis.utils;

import java.util.regex.Pattern;

/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 * 
 * @author liujiduo
 * 
 */

public class Validator {
    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{16,32}$";

    /**
     * 正则表达式：验证验证码
     */
    public static final String REGEX_CODE = "^[0-9]{6}$";

    /**
     * 正则表达式：推广渠道码
     */
    /* public static final String REGEX_C_CODE = "^[a-zA-Z][2][0-9]{3}$"; */

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";    

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 正则表达式：验证DOUBLE
     */
    /*
     * public static final String RECEX_DOUBLE =
     * "^[-//+]?//d+(//.//d*)?|//.//d+$";
     */

    /**
     * 校验用户名
     * 
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        if (!StrUtil.isNull(username)) {
            return Pattern.matches(REGEX_USERNAME, username);
        } else {
            return false;
        }
    }

    /**
     * 校验密码
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        if (!StrUtil.isNull(password)) {
            return Pattern.matches(REGEX_PASSWORD, password);
        } else {
            return false;
        }
    }

    /**
     * 校验验证码
     * 
     * @param code
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isCode(String code) {
        if (!StrUtil.isNull(code)) {
            return Pattern.matches(REGEX_CODE, code);
        } else {
            return false;
        }

    }

    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        if (!StrUtil.isNull(mobile)) {
            return Pattern.matches(REGEX_MOBILE, mobile);
        } else {
            return false;
        }

    }

    /**
     * 校验邮箱
     * 
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        if (!StrUtil.isNull(email)) {
            return Pattern.matches(REGEX_EMAIL, email);
        } else {
            return false;
        }

    }

    /**
     * 校验汉字
     * 
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        if (!StrUtil.isNull(chinese)) {
            return Pattern.matches(REGEX_CHINESE, chinese);
        } else {
            return false;
        }
    }

    /**
     * 校验身份证
     * 
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        if (!StrUtil.isNull(idCard)) {
            return Pattern.matches(REGEX_ID_CARD, idCard);
        } else {
            return false;
        }

    }

    /**
     * 校验URL
     * 
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        if (!StrUtil.isNull(url)) {
            return Pattern.matches(REGEX_URL, url);
        } else {
            return false;
        }

    }

    /**
     * 校验IP地址
     * 
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        if (!StrUtil.isNull(ipAddr)) {
            return Pattern.matches(REGEX_IP_ADDR, ipAddr);
        } else {
            return false;
        }

    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (!StrUtil.isNull(str)) {
            return pattern.matcher(str).matches();
        } else {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        Pattern pattern = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$");
        if (!StrUtil.isNull(str)) {
            return pattern.matcher(str).matches();
        } else {
            return false;
        }
    }

    public static boolean isCCode(String str) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{2}[0-9]{3}$");
        if (!StrUtil.isNull(str)) {
            return pattern.matcher(str).matches();
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String username = "123";
        System.out.println(Validator.isDouble(username));
    }
}
