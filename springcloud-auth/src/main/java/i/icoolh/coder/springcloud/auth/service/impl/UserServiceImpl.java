package i.icoolh.coder.springcloud.auth.service.impl;

import i.icoolh.coder.springcloud.auth.entity.UserAuth;
import i.icoolh.coder.springcloud.auth.mapper.UserMapper;
import i.icoolh.coder.springcloud.auth.service.UserService;
import i.icoolh.coder.springcloud.common.base.mapper.BaseMapper;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.service.impl.MysqlBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangkaihong on 2019/6/21
 */
@Service("userService")
public class UserServiceImpl extends MysqlBaseServiceImpl<UserAuth, Long> implements UserService {
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    @Resource(name = "userMapper")
    protected void setMysqlBaseMapper(MysqlBaseMapper mysqlBaseMapper) {
        this.mysqlBaseMapper = mysqlBaseMapper;
        this.setBaseMapper(mysqlBaseMapper);

    }

    @Override
    public UserAuth getByUserName(String userName) {
        return userMapper.getUserAuthByUserName(userName);
    }
}
