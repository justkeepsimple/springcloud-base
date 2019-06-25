package i.icoolh.coder.springcloud.server.demo.service.impl;

import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.service.impl.MysqlBaseServiceImpl;
import i.icoolh.coder.springcloud.common.utils.PasswdUtil;
import i.icoolh.coder.springcloud.server.demo.entity.JWT;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import i.icoolh.coder.springcloud.server.demo.feign.AuthFeign;
import i.icoolh.coder.springcloud.server.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangkaihong on 2019/6/21
 * @author icoolh
 */
@Service("userService")
public class UserServiceImpl extends MysqlBaseServiceImpl<User, Long> implements UserService {
    @Resource
    private AuthFeign authFeign;

    @Override
    @Resource(name = "userMapper")
    protected void setMysqlBaseMapper(MysqlBaseMapper mysqlBaseMapper) {
        this.mysqlBaseDao = mysqlBaseMapper;
        this.setBaseMapper(mysqlBaseMapper);
    }

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUserName(username);
        User user1 = baseDao.selectOne(user);
        if (user1 != null && PasswdUtil.verify(password, user1.getPasswd())) {
            JWT jwt = authFeign.getToken("Basic YXV0aC1zZXJ2aWNlOmljb29saA==", "password", username, password);
            if (jwt != null){
                user1.setJwt(jwt);
                return user1;
            }
            return null;
        }
        return null;
    }
}
