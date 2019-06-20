package i.icoolh.coder.springcloud.common.utils;

import java.util.Random;

/**
 * Created by yangkaihong on 2018/11/23
 */
public final class RandomUtil {
    private RandomUtil(){};

    /**
     * 获取num位随机数字
     * @param length
     * @return
     */
    public static String getRandom(int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


    //生成随机数字和字母
    public static String getPasswdRandom(int length) {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        //length为几位密码
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                sb.append((char)(random.nextInt(26) + temp));
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }
}
