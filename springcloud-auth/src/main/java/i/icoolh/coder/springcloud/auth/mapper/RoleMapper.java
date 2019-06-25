package i.icoolh.coder.springcloud.auth.mapper;

import i.icoolh.coder.springcloud.auth.entity.RoleAuth;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.server.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends MysqlBaseMapper<RoleAuth, Long> {
}