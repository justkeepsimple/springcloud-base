package i.icoolh.coder.springcloud.server.demo.entity;

import i.icoolh.coder.springcloud.common.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_user")
@Data
public class User extends BaseEntity {

    private static final long serialVersionUID = 8399697967175987120L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "passwd")
    private String passwd;

    @Transient
    private JWT jwt;

}