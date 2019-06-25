package i.icoolh.coder.springcloud.server.demo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import javax.json.Json;
import java.io.IOException;
import java.util.Map;

/**
 * Created by yangkaihong on 2019/6/21
 * @author icoolh
 */
@Configuration
public class JwtConfig {

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    protected JwtAccessTokenConverter jwtAccessTokenConverter() {
        //用作 JWT 转换器
        JwtAccessTokenConverter converter =  new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public.cert");
        String publicKey ;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey); //设置公钥
        return converter;
    }

    public static void main(String[] args) {
        JwtConfig jwtConfig = new JwtConfig();
        JwtAccessTokenConverter jwtAccessTokenConverter = jwtConfig.jwtAccessTokenConverter();
        String value = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJpY29vbGgxIiwic2NvcGUiOlsiYWxsIl0sImV4cCI6MTU2MTUzNzg5MywidXNlciI6eyJjcmVhdGVUaW1lIjpudWxsLCJjcmVhdG9yIjpudWxsLCJ1cGRhdGVUaW1lIjpudWxsLCJ1cGRhdG9yIjpudWxsLCJpZCI6MywidXNlck5hbWUiOiJpY29vbGgxIiwicGFzc3dkIjpudWxsLCJqd3QiOm51bGwsImF1dGhvcml0aWVzIjpbeyJjcmVhdGVUaW1lIjpudWxsLCJjcmVhdG9yIjpudWxsLCJ1cGRhdGVUaW1lIjpudWxsLCJ1cGRhdG9yIjpudWxsLCJpZCI6MywidXNlcklkIjpudWxsLCJyb2xlTmFtZSI6IlRFU1QiLCJhdXRob3JpdHkiOiJURVNUIn1dLCJlbmFibGVkIjp0cnVlLCJwYXNzd29yZCI6bnVsbCwidXNlcm5hbWUiOiJpY29vbGgxIiwiYWNjb3VudE5vbkxvY2tlZCI6dHJ1ZSwiY3JlZGVudGlhbHNOb25FeHBpcmVkIjp0cnVlLCJhY2NvdW50Tm9uRXhwaXJlZCI6dHJ1ZX0sImF1dGhvcml0aWVzIjpbIlRFU1QiXSwianRpIjoiYzY4YzJlNTQtZmIyZC00NWE5LTkyYWUtMjMzNTE2MjUzYWE2IiwiY2xpZW50X2lkIjoiYXV0aC1zZXJ2aWNlIn0.oTUqahZkqCWXhia4oV4VRrB05NX01u1D_35MqEcviHnDAFyM8w4BXFscqRXCVHRs-8gPve2iMmCFQQXuy1Bm5ecgP0X_nAm4uL0nAgHOtk8qvuL0nao39bUzRq8y57QhlipQDKWxLQyn4J21MR9TihhGLpyP_sEfY0q0Ixdw25YOXGGp7fvfkE8KXzzvq5lCDCkoDwnV84aNnOSMLaCxqA8We7NotNYpJxYOwp-Bub4ZXoQdtp3nzr_yiBwvt0JJz25Bq4yfOrwV6nOl4ngOccd8EAbdXEEDGKYp-DLoOChE8o3Z0UvnF5d5LmH3Jo672S9Z7ZUsfmz9zZIwams1Dg";
        Jwt decode = JwtHelper.decode(value);
        String claims = decode.getClaims();
        Map<String, Object> map = JSON.parseObject(claims, Map.class);
        Object user = map.get("user");
        User user2= JSON.parseObject(user.toString(), User.class);
        System.out.println(user2.toString());
    }
}