package i.icoolh.coder.springcloud.server.demo.entity;

import lombok.Data;

/**
 * Created by yangkaihong on 2019/6/21
 */
@Data
public class JWT {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String jti;
}
