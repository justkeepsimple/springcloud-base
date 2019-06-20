package i.icoolh.coder.springcloud.server.demo.service.impl;

import i.icoolh.coder.springcloud.common.base.mapper.BaseMapper;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.service.impl.MysqlBaseServiceImpl;
import i.icoolh.coder.springcloud.server.demo.entity.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangkaihong on 2019/6/20
 */
@Service("orderService")
public class OrderServiceImpl extends MysqlBaseServiceImpl<Order, Integer> {

    @Override
    @Resource(name = "orderMapper")
    protected void setMysqlBaseDao(MysqlBaseMapper mysqlBaseMapper) {
        this.mysqlBaseDao = mysqlBaseMapper;
    }

    @Override
    @Resource(name = "orderMapper")
    protected void setBaseDao(BaseMapper baseMapper) {
        this.baseDao = baseMapper;
    }
}
