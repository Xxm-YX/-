package com.example.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author qiyu
 */
@Getter
@Setter
public class BasePojo {

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间", dataType = "Integer", required = true)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @ApiModelProperty(value = "修改时间", dataType = "Integer", required = true)
    private Date updateTime;

    /**
     * 是否删除
     */
    @LogicDelete
    @ApiModelProperty(value = "是否删除", dataType = "Integer", required = true)
    private Boolean deleted;
}