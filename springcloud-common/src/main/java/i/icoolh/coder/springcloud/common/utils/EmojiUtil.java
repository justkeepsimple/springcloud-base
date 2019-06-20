package i.icoolh.coder.springcloud.common.utils;

import com.github.binarywang.java.emoji.EmojiConverter;

/**
 * @Auther: chen shou hang
 * @Date: 2019/1/19 11:00
 * @Description: 表情工具类
 **/
public class EmojiUtil {

    private static EmojiConverter emojiConverter = EmojiConverter.getInstance();

    /**
     * 将emojiStr转为 带有表情的字符
     *
     * @param emojiStr
     * @return
     */
    public static String emojiConverterUnicodeStr(String emojiStr) {
        String result = emojiConverter.toUnicode(emojiStr);
        return result;
    }

    /**
     * 带有表情的字符串转换为编码
     *
     * @param str
     * @return
     */
    public static String emojiConverterToAlias(String str) {
        String result = emojiConverter.toAlias(str);
        return result;
    }
}
