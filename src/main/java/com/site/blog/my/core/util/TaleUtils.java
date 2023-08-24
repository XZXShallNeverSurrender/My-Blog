package com.site.blog.my.core.util;

import org.thymeleaf.util.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: le soleil se lève
 * @Description:
 * @Date: 17:56 2023/8/23
 */
public class TaleUtils {

    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] encode = messageDigest.digest(source.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte anEncode : encode) {
                String hex = Integer.toHexString(0xff & anEncode);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ignored) {
        }
        return "";
    }

    public static String gravatar(String commentator) {
        String avatarUrl = "https://github.com/identicons/";
        if (!org.springframework.util.StringUtils.hasText(commentator)) {
            commentator = "user@hanshuai.xin";
        }
        String hash = TaleUtils.MD5encode(commentator.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }

}
