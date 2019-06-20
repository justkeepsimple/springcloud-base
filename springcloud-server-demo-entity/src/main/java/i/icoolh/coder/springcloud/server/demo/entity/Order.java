package i.icoolh.coder.springcloud.server.demo.entity;

import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_order")
public class Order extends BaseEntity {
    private static final long serialVersionUID = -7096020302640379651L;
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 餐厅id
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 订单日期yyyyMMdd
     */
    @Column(name = "order_date")
    private String orderDate;

    /**
     * 桌号
     */
    @Column(name = "desk_num")
    private Integer deskNum;

    /**
     * 订单序号 从1递增
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 订单总价
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 订单显示的序号  order_date+order_num+order_num
     */
    @Column(name = "num_")
    private String num;

    /**
     * 用餐人数
     */
    @Column(name = "people_")
    private Integer people;

    /**
     * 订单状态 1：待支付 2：已支付
     */
    @Column(name = "state_")
    private Boolean state;


    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取餐厅id
     *
     * @return shop_id - 餐厅id
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置餐厅id
     *
     * @param shopId 餐厅id
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取订单日期yyyyMMdd
     *
     * @return order_date - 订单日期yyyyMMdd
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * 设置订单日期yyyyMMdd
     *
     * @param orderDate 订单日期yyyyMMdd
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取桌号
     *
     * @return desk_num - 桌号
     */
    public Integer getDeskNum() {
        return deskNum;
    }

    /**
     * 设置桌号
     *
     * @param deskNum 桌号
     */
    public void setDeskNum(Integer deskNum) {
        this.deskNum = deskNum;
    }

    /**
     * 获取订单序号 从1递增
     *
     * @return order_num - 订单序号 从1递增
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单序号 从1递增
     *
     * @param orderNum 订单序号 从1递增
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取订单总价
     *
     * @return total_price - 订单总价
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置订单总价
     *
     * @param totalPrice 订单总价
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取订单显示的序号  order_date+order_num+order_num
     *
     * @return num_ - 订单显示的序号  order_date+order_num+order_num
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置订单显示的序号  order_date+order_num+order_num
     *
     * @param num 订单显示的序号  order_date+order_num+order_num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * 获取用餐人数
     *
     * @return people_ - 用餐人数
     */
    public Integer getPeople() {
        return people;
    }

    /**
     * 设置用餐人数
     *
     * @param people 用餐人数
     */
    public void setPeople(Integer people) {
        this.people = people;
    }

    /**
     * 获取订单状态 1：待支付 2：已支付
     *
     * @return state_ - 订单状态 1：待支付 2：已支付
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置订单状态 1：待支付 2：已支付
     *
     * @param state 订单状态 1：待支付 2：已支付
     */
    public void setState(Boolean state) {
        this.state = state;
    }

}