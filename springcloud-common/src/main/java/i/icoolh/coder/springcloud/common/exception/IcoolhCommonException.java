package i.icoolh.coder.springcloud.common.exception;

/**
 * Created by yangkaihong on 2018/11/22
 */
public class IcoolhCommonException extends IcoolhBaseRuntimeException {

    //有参的构造方法
    public IcoolhCommonException(Integer errorCode, String message) {
        super(message);
        this.detailMessage = message;
        this.errorCode = errorCode;
    }

}