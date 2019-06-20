package i.icoolh.coder.springcloud.common.exception;

/**
 * Created by yangkaihong on 2018/11/21
 */
public abstract class IcoolhBaseRuntimeException extends RuntimeException {
    protected String detailMessage;
    protected Integer errorCode;
    public IcoolhBaseRuntimeException(String message) {
        super(message);
    }
    public String getDetailMessage() {
        return detailMessage;
    }
    public Integer getErrorCode() {
        return errorCode;
    }
}
