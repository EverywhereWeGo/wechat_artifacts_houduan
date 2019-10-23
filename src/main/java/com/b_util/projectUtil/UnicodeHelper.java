package com.b_util.projectUtil;

import org.apache.commons.lang3.StringEscapeUtils;

public class UnicodeHelper {
    public static String decodeUnicode(String dataStr) {
        dataStr = StringEscapeUtils.unescapeJava(dataStr);//去掉转义字符
        if (dataStr.indexOf("\\u") == -1)
            return dataStr;
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
}
