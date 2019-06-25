package i.icoolh.coder.springcloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class SpringcloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAuthApplication.class, args);
    }

}
