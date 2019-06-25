package i.icoolh.coder.springcloud.server.demo.feign;

import i.icoolh.coder.springcloud.server.demo.entity.JWT;
import org.springframework.stereotype.Component;

/**
 * Created by yangkaihong on 2019/6/24
 */
@Component
public class AuthFeignFallBack implements AuthFeign{

    @Override
    public JWT postToken(String authorization, String type, String username, String password) {
        return null;
    }

    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
