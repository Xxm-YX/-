package com.example.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author qiyu
 */
@Data
@ApiModel("用户DTO")
@Table(name = "tk_user")
public class TkUserPojo extends BasePojo {
    /**
     * 主键id
     */
    @Id
    @ApiModelProperty(value = "id",dataType = "Long",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名",dataType = "String",required = true)
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄",dataType = "String",required = true)
    private Integer age;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型",dataType = "Integer",required = true)
    private Integer userType;
}