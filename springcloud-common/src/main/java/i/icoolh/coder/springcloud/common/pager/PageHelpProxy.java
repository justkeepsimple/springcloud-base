package i.icoolh.coder.springcloud.common.pager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * R:返回的数据类型
 * Created by yangkaihong on 2018/12/13
 * @author icoolh
 */
@Log4j2
public final class PageHelpProxy<R,PO> {
    private PO proxyObj;
    private String methodName;
    private Object[] params;
    private Class[] paramsType;

    /**
     * @param proxyObj   代理的对象
     * @param methodName 要调用代理的对象的方法
     * @param params     方法的参数
     */
     public PageHelpProxy(PO proxyObj, String methodName, Object... params) {
        this.proxyObj = proxyObj;
        this.methodName = methodName;
        this.params = params;

    }

    public PageBean<R> doPage(PageBean pageBean) {
        //参数存在
        if (params != null) {
            int len = params.length;
            paramsType = new Class[len];
            //根据参数得到相应的 Class的类对象
            for (int i = 0; i < len; i++) {
                paramsType[i] = params[i].getClass();
            }
        }
        try {
            Method method = proxyObj.getClass().getMethod(methodName, paramsType);
            PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());
            Object result = method.invoke(proxyObj, params);
            List<R> results = (List<R>) result;
            PageInfo<R> pageInfo = new PageInfo<>(results);
            pageBean.setTotalSize(pageInfo.getTotal());
            pageBean.setTotalPage(pageInfo.getPages());
            pageBean.setPageList(results);
            return pageBean;
        } catch (NoSuchMethodException e) {
            log.error("分页代理出错，没有找到要执行的方法。类:{}, 方法{}, 异常信息:{}", proxyObj.getClass(),  methodName, e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("分页代理出错，方法的访问权限异常。类:{}, 方法{}, 异常信息:{}", proxyObj.getClass(),  methodName, e.getMessage());
        } catch (InvocationTargetException e) {
            log.error("分页代理出错，执行方法时异常。类:{}, 方法{}, 异常信息:{}", proxyObj.getClass(),  methodName, e.getMessage());
        }
        return null;
    }
}
