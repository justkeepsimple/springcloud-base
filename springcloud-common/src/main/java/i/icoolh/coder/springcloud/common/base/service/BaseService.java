package i.icoolh.coder.springcloud.common.base.service;

import i.icoolh.coder.springcloud.common.base.QueryFilter;
import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import i.icoolh.coder.springcloud.common.pager.PageBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangkaihong on 2019/6/19
 * @author icoolh
 */
public interface BaseService<T extends BaseEntity, PK extends Serializable> {
    /**
     * 根据主键删除数据
     * 删除操作需要谨慎，故只增加一个删除操作
     * @param pk
     * @return 删除成功记录数
     * @author icoolh
     */
    int deleteByPK(PK pk);

    /**
     * 根据主键更新不为空的字段
     * @param t
     * @return 修改成功记录数
     * @author icoolh
     */
    int updateByPKSelect(T t);

    /**
     * 根据主键更新所有的字段
     * @param t
     * @return 修改成功记录数
     * @author icoolh
     */
    int updateByPK(T t);

    /**
     * 根据主键获取数据
     * @param pk
     * @return
     * @author icoolh
     */
    T getByPK(PK pk);

    /**
     * 根据条件获取单条数据
     * @param queryFilter
     * @return
     * @author icoolh
     */
    T getByCondition(QueryFilter queryFilter);

    /**
     * 获取数据
     * @param queryFilter
     * @return
     * @author icoolh
     */
    List<T> listByCondition(QueryFilter queryFilter);

    /**
     * 查询全部数据
     * @return
     * @author icoolh
     */
    List<T> listAll();
    /**
     * 根据条件统计数据
     * @param queryFilter
     * @return
     * @author icoolh
     */
    int countByCondition(QueryFilter queryFilter);



    /**
     * 保存不为空的字段
     * @param t
     * @return
     * @author icoolh
     */
    int saveSelect(T t);

    /**
     * 利用分页插件获取分页数据
     * @param queryFilter
     * @return
     * @author icoolh
     */
    PageBean<T> listPageBeanByCondition(QueryFilter queryFilter);

}
