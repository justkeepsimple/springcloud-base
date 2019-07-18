package i.icoolh.coder.springcloud.common.base.service;

import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author icoolh
 * @Date 2019/7/16 17:21
 **/
public interface MysqlBaseService<T extends BaseEntity, PK extends Serializable> extends BaseService<T, PK> {
    /**
     * 保存记录 并返回自增id
     * @param t
     * @return
     */
    int saveReturnPK(T t);

    /**
     * 批量保存
     * @param t
     * @return
     */
    int saveList(List<T> t);
}
