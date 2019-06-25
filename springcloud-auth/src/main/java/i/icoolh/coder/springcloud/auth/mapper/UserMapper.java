package i.icoolh.coder.springcloud.auth.mapper;

import i.icoolh.coder.springcloud.auth.entity.UserAuth;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.server.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends MysqlBaseMapper<UserAuth, Long> {
    UserAuth getUserAuthByUserName(@Param("userName") String userName);
}