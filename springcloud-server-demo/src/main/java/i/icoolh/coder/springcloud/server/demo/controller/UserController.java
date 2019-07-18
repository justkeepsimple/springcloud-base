package i.icoolh.coder.springcloud.server.demo.controller;

import i.icoolh.coder.springcloud.common.ResponseMessage;
import i.icoolh.coder.springcloud.common.base.controller.BaseController;
import i.icoolh.coder.springcloud.common.base.service.BaseService;
import i.icoolh.coder.springcloud.common.utils.PasswdUtil;
import i.icoolh.coder.springcloud.common.utils.ResponseMessageUtil;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import i.icoolh.coder.springcloud.server.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by yangkaihong on 2019/6/21
 * @author icoolh
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, Long> {

    @Resource
    private UserService userService;

    @Override
    @Resource(name = "userService")
    protected void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }


    @PostMapping("/register")
    public ResponseMessage postUser(@RequestParam("username") String username,
                                    @RequestParam("password") String password){
        User user = new User();
        user.setPasswd(PasswdUtil.generate(password));
        user.setUserName(username);
        userService.saveSelect(user);
        return ResponseMessageUtil.success("OK");
    }

    @GetMapping("/login")
    public ResponseMessage login(@RequestParam("username") String username,
                                    @RequestParam("password") String password){
        return ResponseMessageUtil.success(userService.login(username, password));
    }
}
