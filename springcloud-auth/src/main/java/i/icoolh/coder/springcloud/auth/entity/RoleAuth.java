package i.icoolh.coder.springcloud.auth.entity;

import i.icoolh.coder.springcloud.server.demo.entity.Role;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by yangkaihong on 2019/6/21
 */
public class RoleAuth extends Role implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return this.getRoleName();
    }
}
