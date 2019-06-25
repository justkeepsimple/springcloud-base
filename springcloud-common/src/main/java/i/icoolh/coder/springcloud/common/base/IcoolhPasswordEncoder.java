package i.icoolh.coder.springcloud.common.base;

import i.icoolh.coder.springcloud.common.utils.PasswdUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 实现spring security 的密码编码, 适配我们自己的密码加密算法
 * Created by yangkaihong on 2019/6/24
 * @icoolh
 */
public class IcoolhPasswordEncoder implements PasswordEncoder {

    /**
     * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or
     * greater hash combined with an 8-byte or greater randomly generated salt.
     *
     * @param rawPassword
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return PasswdUtil.generate(rawPassword.toString());
    }

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return PasswdUtil.verify(rawPassword.toString(), encodedPassword);
    }
}
