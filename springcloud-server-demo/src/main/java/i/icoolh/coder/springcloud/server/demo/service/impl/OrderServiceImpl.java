package i.icoolh.coder.springcloud.server.demo.service.impl;

import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.service.impl.MysqlBaseServiceImpl;
import i.icoolh.coder.springcloud.server.demo.entity.Order;
import i.icoolh.coder.springcloud.server.demo.mapper.OrderMapper;
import i.icoolh.coder.springcloud.server.demo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangkaihong on 2019/6/20
 * @author icoolh
 */
@Service("orderService")
public class OrderServiceImpl extends MysqlBaseServiceImpl<Order, Integer> implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    @Resource(name = "orderMapper")
    protected void setMysqlBaseMapper(MysqlBaseMapper mysqlBaseMapper) {
        this.mysqlBaseMapper = mysqlBaseMapper;
        this.setBaseMapper(mysqlBaseMapper);
    }


}
