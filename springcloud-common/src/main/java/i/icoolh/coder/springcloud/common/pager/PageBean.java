package i.icoolh.coder.springcloud.common.pager;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangkaihong on 2018/12/13
 * @author icoolh
 */
@Data
public class PageBean<T> implements Serializable{
    private static final long serialVersionUID = 533174613877012403L;
    /**
     * 最大每页显示数量
     */
    private final int maxPageSize = 200;
    /**
     * 最小页数
     */
    private final int minPage = 1;
    /**
     * 当前页数 最小为１
     */
    private int currentPage = 1;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 每页显示数量
     */
    private int pageSize = 10;

    /**
     * 总记录数
     */
    private Long totalSize;

    /**
     * 数据
     */
    private List<T> pageList;
}
