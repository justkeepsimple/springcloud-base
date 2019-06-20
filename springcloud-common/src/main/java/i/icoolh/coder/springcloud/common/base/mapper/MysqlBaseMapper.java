package i.icoolh.coder.springcloud.common.base.mapper;

import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by yangkaihong on 2019/6/20
 */
public interface MysqlBaseMapper<T extends BaseEntity, PK> extends BaseMapper<T, PK>, MySqlMapper<T> {
}
