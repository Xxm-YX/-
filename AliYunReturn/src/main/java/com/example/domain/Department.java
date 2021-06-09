package com.example.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class Department {

    @NotNull(message = "部门编码不能为空")
    private Integer sn;

    @NotBlank(message = "部门名称不能为空")
    private String name;
}
