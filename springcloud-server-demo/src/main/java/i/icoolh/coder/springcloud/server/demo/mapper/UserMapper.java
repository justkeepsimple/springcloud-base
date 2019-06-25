package i.icoolh.coder.springcloud.server.demo.mapper;

import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MysqlBaseMapper<User, Long> {
}