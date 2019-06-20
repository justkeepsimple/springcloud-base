package i.icoolh.coder.springcloud.common.base.service.impl;

import com.github.pagehelper.PageHelper;
import i.icoolh.coder.springcloud.common.base.QueryFilter;
import i.icoolh.coder.springcloud.common.base.mapper.MysqlBaseMapper;
import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import i.icoolh.coder.springcloud.common.pager.PageBean;
import i.icoolh.coder.springcloud.common.pager.PageHelpProxy;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangkaihong on 2019/6/20
 */
public abstract class MysqlBaseServiceImpl<T extends BaseEntity, PK extends Serializable> extends BaseServiceImpl<T, PK>{
    protected MysqlBaseMapper<T, PK> mysqlBaseDao;

    protected abstract void setMysqlBaseDao(MysqlBaseMapper mysqlBaseMapper);
    @Override
    public int saveReturnPK(T t) {
        return mysqlBaseDao.insertUseGeneratedKeys(t);
    }

    @Override
    public int saveList(List<T> t) {
        return mysqlBaseDao.insertList(t);
    }

    @Override
    public PageBean<T> listPageBeanByCondition(QueryFilter queryFilter) {
        PageHelpProxy<T, ? extends MysqlBaseMapper> pageHelpProxy = new PageHelpProxy(mysqlBaseDao, "selectByExample", queryFilter.getExample());
        return  pageHelpProxy.doPage(queryFilter.getPageBean());
    }

    @Override
    public T getByCondition(QueryFilter queryFilter) {
        PageHelper.startPage(1, 1);
        List<T> ts = baseDao.selectByExample(queryFilter.getExample());
        return null == ts ? null :ts.get(0);
    }
}
