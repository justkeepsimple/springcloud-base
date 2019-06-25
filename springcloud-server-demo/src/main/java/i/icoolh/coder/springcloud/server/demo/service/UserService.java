package i.icoolh.coder.springcloud.server.demo.service;

import i.icoolh.coder.springcloud.common.base.service.BaseService;
import i.icoolh.coder.springcloud.server.demo.entity.User;

/**
 * Created by yangkaihong on 2019/6/21
 */
public interface UserService extends BaseService<User, Long> {
    User login(String username, String password);
}
