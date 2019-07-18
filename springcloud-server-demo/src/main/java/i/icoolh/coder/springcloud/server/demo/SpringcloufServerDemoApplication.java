package i.icoolh.coder.springcloud.server.demo;

import com.github.pagehelper.PageHelper;
import i.icoolh.coder.springcloud.common.pager.PageHelperFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class SpringcloufServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloufServerDemoApplication.class, args);
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        return PageHelperFactory.getPageHelper();
    }
}
