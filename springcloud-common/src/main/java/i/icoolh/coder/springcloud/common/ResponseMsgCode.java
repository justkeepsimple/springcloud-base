package i.icoolh.coder.springcloud.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangkaihong on 2018/11/16
 * 状态码和对应响应信息
 */
public class ResponseMsgCode {
    private static final Map<Integer, String> CODE_MSG =  new HashMap<>(32);
    /**
     * 响应成功
     */
    public static final Integer CODE_SUCCESS = 200;

    /**
     * 系统错误
     */
    public static final Integer CODE_FAIL = 1001;

    /**
     * badURL
     */
    public static final Integer ERROR_URL = 1002;

    /**
     * 数据库操作失败
     */
    public static final Integer ERROR_OPT_DB = 1003;
    static {
        CODE_MSG.put(CODE_SUCCESS, "成功");
        CODE_MSG.put(CODE_FAIL, "系统错误");
        CODE_MSG.put(ERROR_URL, "ERROR url！");
        CODE_MSG.put(ERROR_OPT_DB, "数据库操作失败！");
    }

    public static String getMsgByCode(Integer code) {
        return CODE_MSG.get(code);
    }
}
