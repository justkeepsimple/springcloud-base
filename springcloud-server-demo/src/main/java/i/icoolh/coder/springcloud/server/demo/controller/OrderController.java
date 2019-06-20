package i.icoolh.coder.springcloud.server.demo.controller;

import i.icoolh.coder.springcloud.common.ResponseMessage;
import i.icoolh.coder.springcloud.common.base.controller.BaseController;
import i.icoolh.coder.springcloud.common.base.service.BaseService;
import i.icoolh.coder.springcloud.common.utils.ResponseMessageUtil;
import i.icoolh.coder.springcloud.server.demo.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangkaihong on 2019/6/20
 * @author icoolh
 */
@RestController
public class OrderController extends BaseController<Order, Integer> {

    @Override
    @Resource(name = "orderService")
    protected void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/order/{id}")
    public ResponseMessage<Order> getByPk(@PathVariable("id") Integer id){
        System.out.println(id);
        return ResponseMessageUtil.success(baseService.getByPK(id));
    }
}
