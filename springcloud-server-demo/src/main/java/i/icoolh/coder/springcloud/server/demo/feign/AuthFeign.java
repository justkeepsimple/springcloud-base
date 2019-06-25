package i.icoolh.coder.springcloud.server.demo.feign;

import i.icoolh.coder.springcloud.server.demo.entity.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yangkaihong on 2019/6/21
 */
@FeignClient(name = "auth-server" ,fallback = AuthFeignFallBack.class)
public interface AuthFeign {
    @PostMapping(value = "/oauth/token")
    JWT postToken(@RequestHeader("Authorization") String authorization,
                  @RequestParam("grant_type") String type,
                  @RequestParam("username") String username, @RequestParam("password") String password);
    @GetMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader("Authorization") String authorization,
                 @RequestParam("grant_type") String type,
                 @RequestParam("username") String username, @RequestParam("password") String password);

}
