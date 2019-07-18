package i.icoolh.coder.springcloud.server.demo.service;

import i.icoolh.coder.springcloud.common.base.service.MysqlBaseService;
import i.icoolh.coder.springcloud.server.demo.entity.User;

/**
 * Created by yangkaihong on 2019/6/21
 * @author icoolh
 */
public interface UserService extends MysqlBaseService<User, Long> {
    User login(String username, String password);
}
