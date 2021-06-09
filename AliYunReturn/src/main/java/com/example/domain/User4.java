package com.example.domain;

import com.example.valid.Update;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class User4 {

    @NotNull(message = "id不能为空",groups = {Update.class})
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
    private Department department;

}
