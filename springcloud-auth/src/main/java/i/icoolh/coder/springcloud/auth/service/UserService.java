package i.icoolh.coder.springcloud.auth.service;

import i.icoolh.coder.springcloud.auth.entity.UserAuth;
import i.icoolh.coder.springcloud.common.base.service.BaseService;
import i.icoolh.coder.springcloud.server.demo.entity.User;

/**
 * Created by yangkaihong on 2019/6/21
 */
public interface UserService extends BaseService<UserAuth, Long> {
    UserAuth getByUserName(String userName);
}
