package com.github.zhiwen.util;

/**
 * @author: zhiwen.deng@shopee.com
 * @date: 2023/01/30/ 6:48 PM
 * @Description: TODO
 */
public class CharUtil {
    public static boolean isBlankChar(char c) {
        return isBlankChar((int) c);
    }

    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) ||
                c == '\ufeff' || c == '\u202a';
    }
}
