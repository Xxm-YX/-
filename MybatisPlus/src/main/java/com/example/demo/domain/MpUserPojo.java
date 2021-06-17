package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 通用Mapper中叫 @Table(name = "tk_user")
 *
 */
@Data
@TableName("mp_user")
public class MpUserPojo {

    /**
     * Mybatis-Plus默认名为"id"的字段为主键
     * 如果主键名不叫id，而是'userId'，必须通过@TableId标识
     * 主键生成策略默认是无意义的long数值，可以指定@TableId的IdType属性为AUTO，随数据库自增
     * 加上@TableId(type = IdType.AUTO)
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除，逻辑删除请用 @TableLogic
     */
    private Boolean deleted;

    /**
     * 乐观锁版本号，需要乐观锁请用 @Version
     * 支持的字段类型:
     * long,
     * Long,
     * int,
     * Integer,
     * java.util.Date,
     * java.sql.Timestamp,
     * java.time.LocalDateTime
     */
    private Integer version;
}
