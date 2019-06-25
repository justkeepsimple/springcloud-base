package i.icoolh.coder.springcloud.auth.service.impl;

import i.icoolh.coder.springcloud.auth.entity.RoleAuth;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.service.impl.MysqlBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangkaihong on 2019/6/21
 */
@Service("roleService")
public class RoleServiceImpl extends MysqlBaseServiceImpl<RoleAuth, Long> {
    @Override
    @Resource(name = "roleMapper")
    protected void setMysqlBaseMapper(MysqlBaseMapper mysqlBaseMapper) {
        this.mysqlBaseDao = mysqlBaseMapper;
        this.setBaseMapper(mysqlBaseMapper);
    }

}
