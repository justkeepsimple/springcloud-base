package i.icoolh.coder.springcloud.auth.entity;

import i.icoolh.coder.springcloud.server.demo.entity.Role;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Transient;
import java.util.Collection;
import java.util.List;

/**
 * Created by yangkaihong on 2019/6/21
 */
public class UserAuth extends User implements UserDetails {
    @Transient
    private List<RoleAuth> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.getPasswd();
    }

    @Override
    public String getUsername() {
        return this.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
