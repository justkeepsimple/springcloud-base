package i.icoolh.coder.springcloud.common.utils;

import i.icoolh.coder.springcloud.common.ResponseMessage;
import i.icoolh.coder.springcloud.common.ResponseMsgCode;

/**
 * Created by yangkaihong on 2018/11/16
 * @author icoolh
 */
public final class ResponseMessageUtil {
    private ResponseMessageUtil(){}
    private static final Integer SUCCESS_CODE = ResponseMsgCode.CODE_SUCCESS;
    private static final Integer FAIL_CODE = ResponseMsgCode.CODE_FAIL;

    /**
     * 响应成功 返回状态码和描述信息
     * @return
     */
    public static ResponseMessage success(){
        return success("成功！");
    }

    /**
     * 响应成功 自定义返回消息
     * @param DIYMsg
     * @return
     */
    public static ResponseMessage success(String DIYMsg) {
        return new ResponseMessage(SUCCESS_CODE, DIYMsg, null);

    }
    public static ResponseMessage success(String DIYMsg, Object data) {
        return new ResponseMessage(SUCCESS_CODE, DIYMsg, data);
    }

    public static ResponseMessage success(Integer successCode,String DIYMsg, Object data) {
        return new ResponseMessage(successCode, DIYMsg, data);
    }
    /**
     * 响应成功 返回状态码、描述信息和数据
     * @return
     */
    public static ResponseMessage success(Object data){
        return new ResponseMessage(SUCCESS_CODE, ResponseMsgCode.getMsgByCode(SUCCESS_CODE), data);
    }


    public static ResponseMessage fail(){
        return fail(FAIL_CODE, ResponseMsgCode.getMsgByCode(FAIL_CODE), null);

    }

    public static ResponseMessage fail(Object data){
        return fail(FAIL_CODE, ResponseMsgCode.getMsgByCode(FAIL_CODE), data);

    }

    public static ResponseMessage fail(Integer errorCode){
        return fail(errorCode, ResponseMsgCode.getMsgByCode(errorCode), null);
    }
    public static ResponseMessage fail(String DIYMsg){
        return fail(FAIL_CODE, DIYMsg, null);
    }

    public static ResponseMessage fail(Integer errorCode,String DIYMsg){
        return fail(errorCode, DIYMsg, null);
    }
    public static ResponseMessage fail(Integer errorCode,Object data){
        return fail(errorCode, ResponseMsgCode.getMsgByCode(errorCode), data);
    }

    public static ResponseMessage fail(Integer errorCode, String msg, Object data){
        return new ResponseMessage(errorCode, msg, data);
    }

}
