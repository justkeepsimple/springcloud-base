package i.icoolh.coder.springcloud.server.demo.mapper;

import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.server.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.annotation.RegisterMapper;

@Mapper
public interface OrderMapper extends MysqlBaseMapper<Order, Integer> {
}