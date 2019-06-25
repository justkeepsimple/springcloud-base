package i.icoolh.coder.springcloud.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

/**
 * Created by yangkaihong on 2018/11/12
 */
public final class PasswdUtil {
    private PasswdUtil(){}

    //必选包含数字、大写字母、小写字母、特殊字符，长度在8到15位
    private static final String SEC_PASSWORD =
            "^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[@!#$%^&*()_+\\.\\-\\?<>'\"|=]+).{8,15}$";
    /**
     * 字符串加密函数MD5实现
     */
    public final static String md5(String password){
        MessageDigest md;
        try {
            // 生成一个MD5加密计算摘要
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String pwd = new BigInteger(1, md.digest()).toString(16);
            return pwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    /**
     * 判断一个密码是否健壮
     * 必选包含数字、大写字母、小写字母、特殊字符，长度在8到15位
     * @param password
     * @return
     */
    public final static  boolean isSec(String password){
        return RegexUtil.isMatche(password,SEC_PASSWORD);
    }


    /**
     * 生成随机length位密码  数字加字母
     * @param length
     * @return
     */
    public final static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //length为几位密码
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     * 32位长度
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 生成含有随机盐的密码
     */
    public static String generate(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append(i);
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);//0 2 4 6 8 10 ... 30
            char c = salt.charAt(i / 3); // 0 1 2 3 ... 15
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1); // 1 3 5 7 9 ... 31
        }
        return new String(cs);
    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

}
