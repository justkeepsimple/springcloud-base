package i.icoolh.coder.springcloud.common.base;

import i.icoolh.coder.springcloud.common.Enums.ConditonEnum;
import i.icoolh.coder.springcloud.common.pager.PageBean;
import i.icoolh.coder.springcloud.common.utils.StringUtil;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * Created by yangkaihong on 2019/6/19
 * @author icoolh
 */
public class QueryFilter implements Serializable {

    private static final long serialVersionUID = 1868092499660316704L;
    /**
     * 排序方式 asc desc
     */
    private static final String ORDER = "order";
    /**
     * 排序字段
     */
    private static final String SORT = "sort";
    /**
     * 全模糊查询字段  where column like %avalue%
     */
    private static final String ACOLUMN = "acolumn";

    /**
     * 全模糊值  %avalue%
     */
    private static final String AVALUE = "avalue";

    /**
     * 右模糊查询字段  where column like rvalue%
     */
    private static final String RCOLUMN = "rcolumn";

    /**
     * 右模糊值  rvalue%
     */
    private static final String RVALUE = "rvalue";

    /**
     * 分隔符
     */
    private static final String SPLITFALG = "@icoolh";

    private ServletRequest request;

    /**
     * 分页参数 懒加载
     */
    private PageBean pageBean;

    private Example example;

    private Example.Criteria criteria;

    public QueryFilter(Class<?> clazz){
        this.example = new Example(clazz);
        this.criteria = this.example.createCriteria();
    }

    public QueryFilter(Class<?> clazz, ServletRequest request){
        this.example = new Example(clazz);
        this.criteria = this.example.createCriteria();
        this.request = request;
        this.pageBean = new PageBean<>();
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        if (!StringUtil.isBlank(currentPage)){
            this.pageBean.setCurrentPage(Integer.valueOf(currentPage));
        }
        if (!StringUtil.isBlank(pageSize)){
            this.pageBean.setPageSize(Integer.valueOf(pageSize));
        }
        String acolumn = request.getParameter(ACOLUMN);
        String rcolumn = request.getParameter(RCOLUMN);
        String avalue = request.getParameter(AVALUE);
        String rvalue = request.getParameter(RVALUE);
        this.setLikeValue(acolumn, avalue, true);
        this.setLikeValue(rcolumn, rvalue);
        //排序方式
        String order = request.getParameter(ORDER);
        //排序字段
        String sort = request.getParameter(SORT);
        this.setOrderby(sort, order);
    }

    /**
     * 增加where 条件
     * @param conditionEnum
     * @param column
     * @param value
     */
    public void addConditions(ConditonEnum conditionEnum, String column, Object value){
        if (conditionEnum == ConditonEnum.ALIKE){
            this.criteria.andCondition(column + " like", "%" + value + "%");
        }else if (conditionEnum == ConditonEnum.RLIKE){
            this.criteria.andCondition(column + " like", value + "%");
        }else if (conditionEnum == ConditonEnum.EQ){
            this.criteria.andCondition(column + " =", value);
        }
    }

    /**
     *
     * @param sort 排序字段
     * @param order 排序方式
     */
    private void setOrderby(String sort, String order){
        if (!StringUtil.isBlank(sort) && !StringUtil.isBlank(order)){
            String[] sorts = sort.split(SPLITFALG);
            String[] orders = order.split(SPLITFALG);
            if (sorts.length == orders.length){
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < orders.length; i++) {
                    boolean flag = StringUtil.isBlank(sorts[i]) || StringUtil.isBlank(orders[i])
                            || (!"asc".equalsIgnoreCase(orders[i]) && !"desc".equalsIgnoreCase(orders[i]));
                    if (flag){
                        continue;
                    }
                    sb.setLength(0);
                    sb.append(sorts[i]);
                    sb.append(" ");
                    sb.append(orders[i]);
                    this.example.setOrderByClause(sb.toString());

                }
            }
        }

    }

    /**
     * 右模糊匹配查询
     * @param column 查询的字段
     * @param value   查询字段的值
     */
    private void setLikeValue(String column, String value){
        this.setLikeValue(column, value, false);
    }


    /**
     *
     * @param column  查询的字段
     * @param value   查询字段的值
     * @param allLike 是否全模糊匹配
     */
    private void setLikeValue(String column, String value, boolean allLike){
        if (!StringUtil.isBlank(column) && !StringUtil.isBlank(value)){
            String[] columns = column.split(SPLITFALG);
            String[] values = value.split(SPLITFALG);
            if (columns.length == values.length){
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < values.length; i++) {
                    if (StringUtil.isBlank(columns[i]) || StringUtil.isBlank(values[i])){
                        continue;
                    }
                    sb.setLength(0);
                    if (allLike){
                        sb.append("%");
                    }
                    sb.append(values[i].replace("%", ""));
                    sb.append("%");
                    this.criteria.andLike(columns[i], sb.toString());

                }
            }
        }
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public PageBean getPageBean() {
        return pageBean == null? new PageBean<>() : pageBean;
    }

    public Example getExample() {
        return example;
    }

    public Example.Criteria getCriteria() {
        return criteria;
    }
}
