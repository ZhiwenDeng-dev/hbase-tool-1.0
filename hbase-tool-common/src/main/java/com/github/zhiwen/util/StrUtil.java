package com.github.zhiwen.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhiwen.deng@shopee.com
 * @date: 2023/01/30/ 6:46 PM
 * @Description: TODO
 */
public class StrUtil {

    public static boolean isBlank(CharSequence str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!CharUtil.isBlankChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    public static Map<String, String> parsePropertyToMapFromStr(String prop) {
        if (isBlank(prop)) {
            return new HashMap<>();
        }
        Map<String, String> property = new HashMap<>(4);
        for (String p : prop.split(";")) {
            if (isBlank(p)) {
                continue;
            }
            if (!p.contains("=")) {
                continue;
            }
            String[] p_s = p.split("=");
            if (p_s.length == 2) {
                property.put(p_s[0], p_s[1]);
            }
        }
        return property;
    }


    public static void main(String[] args) {
        System.out.println(isBlank("a dbc"));
        System.out.println(parsePropertyToMapFromStr("test=12=239;key=23;"));
    }
}
