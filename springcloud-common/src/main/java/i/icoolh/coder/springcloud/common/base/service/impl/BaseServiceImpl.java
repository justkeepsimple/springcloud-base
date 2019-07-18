package i.icoolh.coder.springcloud.common.base.service.impl;

import com.github.pagehelper.PageHelper;
import i.icoolh.coder.springcloud.common.base.QueryFilter;
import i.icoolh.coder.springcloud.common.base.mapper.BaseMapper;
import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.service.BaseService;
import i.icoolh.coder.springcloud.common.pager.PageBean;
import i.icoolh.coder.springcloud.common.pager.PageHelpProxy;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yangkaihong on 2019/6/19
 */
public abstract class BaseServiceImpl<T extends BaseEntity, PK extends Serializable> implements BaseService<T, PK> {
    protected BaseMapper<T, PK> baseMapper;

    protected abstract void setBaseMapper(@NonNull BaseMapper baseMapper);
    @Override
    @Transactional
    public int deleteByPK(PK pk) {
         return baseMapper.deleteByPrimaryKey(pk);
    }

    @Override
    @Transactional
    public int updateByPKSelect(T t) {
        Date date = new Date(System.currentTimeMillis());
        t.setUpdateTime(date);
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional
    public int updateByPK(T t) {
        Date date = new Date(System.currentTimeMillis());
        t.setUpdateTime(date);
        return baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public T getByPK(PK pk) {
        return baseMapper.selectByPrimaryKey(pk);
    }

    @Override
    public T getByCondition(QueryFilter queryFilter) {
        PageHelper.startPage(1, 1);
        List<T> ts = baseMapper.selectByExample(queryFilter.getExample());
        return null == ts ? null : ts.get(0);
    }

    @Override
    public List<T> listByCondition(QueryFilter queryFilter) {
        return baseMapper.selectByExample(queryFilter.getExample());
    }

    @Override
    public int countByCondition(QueryFilter queryFilter) {
        return baseMapper.selectCountByExample(queryFilter.getExample());
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int saveSelect(T t) {
        return baseMapper.insertSelective(t);
    }

    /**
     * 利用分页插件获取分页数据
     * @param queryFilter
     * @return
     */
    @Override
    public PageBean<T> listPageBeanByCondition(QueryFilter queryFilter) {
        PageHelpProxy<T, ? extends MysqlBaseMapper> pageHelpProxy = new PageHelpProxy(baseMapper, "selectByExample", queryFilter.getExample());
        return  pageHelpProxy.doPage(queryFilter.getPageBean());
    }
}
