package i.icoolh.coder.springcloud.server.demo.controller;

import i.icoolh.coder.springcloud.common.ResponseMessage;
import i.icoolh.coder.springcloud.common.base.controller.BaseController;
import i.icoolh.coder.springcloud.common.base.service.BaseService;
import i.icoolh.coder.springcloud.common.utils.ResponseMessageUtil;
import i.icoolh.coder.springcloud.server.demo.entity.Order;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import i.icoolh.coder.springcloud.server.demo.service.OrderService;
import i.icoolh.coder.springcloud.server.demo.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangkaihong on 2019/6/20
 * @author icoolh
 */
@RestController
@Api("订单REST Api")
public class OrderController extends BaseController<Order, Integer> {
    @Resource
    private OrderService orderService;

    @Override
    @Resource(name = "orderService")
    protected void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/order/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NORMAL')")
    public ResponseMessage<Order> getByPk(@PathVariable("id") Integer id){
        System.out.println(id);
        return ResponseMessageUtil.success(orderService.getByPK(id));
    }

    @ApiOperation(value = "test JWT method", notes = "test JWT method notes")
    @GetMapping("/test")
    public ResponseMessage<User> test(HttpServletRequest request){
        return ResponseMessageUtil.success(JwtUtil.getUserFromJWT(request));
    }

    @GetMapping("/order")
    public ResponseMessage<Order> listAll(){
        return ResponseMessageUtil.success(orderService.listAll());
    }
}
