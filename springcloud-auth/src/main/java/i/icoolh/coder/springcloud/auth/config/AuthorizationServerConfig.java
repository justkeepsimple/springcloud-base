package i.icoolh.coder.springcloud.auth.config;

import i.icoolh.coder.springcloud.auth.jwt.IcoolhJwtAccessTokenConverter;
import i.icoolh.coder.springcloud.common.utils.PasswdUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;

/**
 * 认证服务
 * Created by yangkaihong on 2019/6/21
 * @author icoolh
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        String finalSecret = new BCryptPasswordEncoder().encode("icoolh");
        //配置两个客户端,一个用于password认证一个用于client认证
        clients.inMemory()
                /*.withClient("client_1")
                .resourceIds("demo")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("ADMIN")
                .secret(finalSecret)*/
                //oauth/token 的帐号
                .withClient("auth-service")
                //oauth/token 的密码
                .secret(PasswdUtil.generate("icoolh"))
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("all")
                //.secret(finalSecret)
                .accessTokenValiditySeconds(3600 * 24)
                .refreshTokenValiditySeconds(3600 * 24 * 7);
    }

    /*@Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //设置签名密钥
        jwtAccessTokenConverter.setSigningKey("icoolh");
        return jwtAccessTokenConverter;
    }*/

    /**
     * JWT存储token
     * @return
     */
    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(icoolhJwtAccessTokenConverter());
    }

    @Bean
    protected IcoolhJwtAccessTokenConverter icoolhJwtAccessTokenConverter() {
        //注意此处需要相应的jks文件
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("fzp-jwt.jks"), "icoolh".toCharArray());
        IcoolhJwtAccessTokenConverter converter = new IcoolhJwtAccessTokenConverter();
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("fzp-jwt"));
        return converter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /*endpoints.tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter())
                .reuseRefreshTokens(true)
                //配置以生效password模式
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);*/
        endpoints.tokenStore(jwtTokenStore())
                .tokenEnhancer(icoolhJwtAccessTokenConverter())
                .authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
        //.tokenServices();
        ;

    }

}
