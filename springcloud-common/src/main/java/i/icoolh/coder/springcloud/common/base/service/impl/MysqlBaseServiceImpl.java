package i.icoolh.coder.springcloud.common.base.service.impl;

import com.github.pagehelper.PageHelper;
import i.icoolh.coder.springcloud.common.base.QueryFilter;
import i.icoolh.coder.springcloud.common.base.mapper.BaseMapper;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import i.icoolh.coder.springcloud.common.pager.PageBean;
import i.icoolh.coder.springcloud.common.pager.PageHelpProxy;
import io.micrometer.core.lang.NonNull;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yangkaihong on 2019/6/20
 */
public abstract class MysqlBaseServiceImpl<T extends BaseEntity, PK extends Serializable> extends BaseServiceImpl<T, PK>{
    protected MysqlBaseMapper<T, PK> mysqlBaseMapper ;

    protected abstract void setMysqlBaseMapper(@NonNull MysqlBaseMapper mysqlBaseMapper);

    @Override
    protected void setBaseMapper(@NonNull BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Transactional
    public int saveReturnPK(T t) {
        return mysqlBaseMapper.insertUseGeneratedKeys(t);
    }

    @Transactional
    public int saveList(List<T> t) {
        return mysqlBaseMapper.insertList(t);
    }

}
