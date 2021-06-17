package com.example.demo.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_user_log")
public class UserLogDO {

    private Long id;

    /**
     * 本次操作的系统模块
     */
    private String moduleCode;

    /**
     * 操作类型
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 操作人
     */
    private Long operatorId;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 操作内容
     */
    private String content;
}
