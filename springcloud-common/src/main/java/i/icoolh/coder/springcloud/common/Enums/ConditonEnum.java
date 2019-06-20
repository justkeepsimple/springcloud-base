package i.icoolh.coder.springcloud.common.Enums;

/**
 * 条件查询枚举类
 * Created by yangkaihong on 2019/6/20
 * @author icoolh
 */
public enum ConditonEnum {
    /**
     * like 全模糊查询
     */
    ALIKE,
    /**
     * like 右模糊查询
     */
    RLIKE,
    /**
     * 等于 查询
     */
    EQ;
    private ConditonEnum(){}
}
