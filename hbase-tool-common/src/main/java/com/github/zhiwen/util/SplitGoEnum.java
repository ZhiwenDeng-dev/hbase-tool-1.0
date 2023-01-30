package com.github.zhiwen.util;

/**
 * @author: zhiwen.deng@shopee.com
 * @date: 2023/01/30/ 6:50 PM
 * @Description: TODO
 */
public enum SplitGoEnum {
    /**
     * 预分区策略，十六进制前缀
     */
    HEX_STRING_SPLIT("HexStringSplit"),
    /**
     * 十进制前缀
     */
    DECIMAL_STRING_SPLIT("DecimalStringSplit"),
    /**
     * 随机字符串前缀
     */
    UNIFORM_SPLIT("UniformSplit");

    private final String splitGo;

    SplitGoEnum(String splitGo) {
        this.splitGo = splitGo;
    }

    public String getSplitGo() {
        return splitGo;
    }

    public static SplitGoEnum getSplitGoEnum(String splitGo) {
        for (SplitGoEnum splitGoEnum : SplitGoEnum.values()) {
            if (splitGoEnum.splitGo.equals(splitGo)) {
                return splitGoEnum;
            }
        }
        return null;
    }
}
