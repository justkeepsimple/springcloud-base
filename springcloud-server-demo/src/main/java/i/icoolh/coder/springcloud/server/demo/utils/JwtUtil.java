package i.icoolh.coder.springcloud.server.demo.utils;

import com.alibaba.fastjson.JSON;
import i.icoolh.coder.springcloud.common.Const;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by yangkaihong on 2019/6/25
 * @author icoolh
 */
public final class JwtUtil {
    private JwtUtil(){}
    public static final User getUserFromJWT(HttpServletRequest request){
        String authorization = request.getHeader(Const.JWT_AUTHORIZATION);
        User user = null;
        try {
            if (authorization.indexOf("Bearer") == 0){
                String[] bearers = authorization.split("Bearer");
                authorization = bearers[1].trim();
            }
            Jwt decode = JwtHelper.decode(authorization);
            String claims = decode.getClaims();
            Map<String, Object> map = JSON.parseObject(claims, Map.class);
            Object userObj = map.get("user");
            user = JSON.parseObject(userObj.toString(), User.class);
        } catch (Exception e){
            return null;
        }
        return user;
    }
}
