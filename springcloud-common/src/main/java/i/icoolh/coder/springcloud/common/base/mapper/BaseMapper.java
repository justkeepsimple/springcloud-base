package i.icoolh.coder.springcloud.common.base.mapper;

import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by yangkaihong on 2019/6/19
 * @author icoolh
 */
public interface BaseMapper<T extends BaseEntity, PK> extends  Mapper<T> {

}
