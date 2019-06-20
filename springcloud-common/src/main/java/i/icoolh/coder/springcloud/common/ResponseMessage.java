package i.icoolh.coder.springcloud.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yangkaihong on 2018/11/16
 * @author icoolh
 */
@Data
public class ResponseMessage<T> implements Serializable {
    private static final long serialVersionUID = -2306369506014583038L;
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public ResponseMessage(){}

    public ResponseMessage(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
