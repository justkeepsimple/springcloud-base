package i.icoolh.coder.springcloud.common.base.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yangkaihong on 2019/6/19
 * @author
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 4792482722185259931L;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "creator")
    private Long creator;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "updator")
    private Long updator;
}
