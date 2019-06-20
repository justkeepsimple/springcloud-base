package i.icoolh.coder.springcloud.common.base.controller;

import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import i.icoolh.coder.springcloud.common.base.service.BaseService;

import java.io.Serializable;

/**
 * Created by yangkaihong on 2019/6/19
 */

public abstract class BaseController<T extends BaseEntity, PK extends Serializable> {
    protected BaseService<T,PK> baseService;
    protected abstract void setBaseService(BaseService baseService);
}
