package i.icoolh.coder.springcloud.discovery;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by yangkaihong on 2019/3/5
 * Greenwich.RELEASE 坑一 这个版本的security 会默认进行csrf攻击防御,我选择直接关闭防御。
 */
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        更好的办法是,配置/eureka/**忽略csrf防御拦截,直接放行(/eureka/**是在application.yml中配置的eureka注册地址)
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

}
