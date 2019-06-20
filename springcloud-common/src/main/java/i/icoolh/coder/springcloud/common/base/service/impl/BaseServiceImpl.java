package i.icoolh.coder.springcloud.common.base.service.impl;

import i.icoolh.coder.springcloud.common.base.QueryFilter;
import i.icoolh.coder.springcloud.common.base.mapper.BaseMapper;
import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import i.icoolh.coder.springcloud.common.base.service.BaseService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yangkaihong on 2019/6/19
 */
public abstract class BaseServiceImpl<T extends BaseEntity, PK extends Serializable> implements BaseService<T, PK> {
    protected BaseMapper<T, PK> baseDao;

    protected abstract void setBaseDao(BaseMapper baseMapper);
    @Override
    public int deleteByPK(PK pk) {
         return baseDao.deleteByPrimaryKey(pk);
    }

    @Override
    public int updateByPKSelect(T t) {
        Date date = new Date(System.currentTimeMillis());
        t.setUpdateTime(date);
        return baseDao.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPK(T t) {
        Date date = new Date(System.currentTimeMillis());
        t.setUpdateTime(date);
        return baseDao.updateByPrimaryKey(t);
    }

    @Override
    public T getByPK(PK pk) {
        return baseDao.selectByPrimaryKey(pk);
    }

    @Override
    public T getByCondition(QueryFilter queryFilter) {
        List<T> ts = baseDao.selectByExample(queryFilter.getExample());
        return null == ts ? null : ts.get(0);
    }

    @Override
    public List<T> listByCondition(QueryFilter queryFilter) {
        return baseDao.selectByExample(queryFilter.getExample());
    }

    @Override
    public int countByCondition(QueryFilter queryFilter) {
        return baseDao.selectCountByExample(queryFilter.getExample());
    }

    @Override
    public int saveSelect(T t) {
        return baseDao.insertSelective(t);
    }
}
