package com.example.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class User2 {

    @NotNull(message = "id不能为空")
    private Long id;


    private String name;
    @NotNull(message = "年龄不能为空")
    @Max(value = 35, message = "年龄不超过35")
    @Min(value = 18, message = "年龄不小于18")
    private String age;

    /**
     * 嵌套校验
     * @Validated不支持嵌套校验，只能用@Valid：
     */
    @NotNull
    @Valid
    private Department department;

    @Data
    static class Department{
        @NotNull(message = "部门编码不能为空")
        private Integer sn;

        @NotBlank(message = "部门名称不能为空")
        private String name;
    }
}
