package com.example.domain;

import com.example.valid.Add;
import com.example.valid.Update;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分组校验
 */
@Data
public class User3 {

    @NotNull(message = "id不能为空",groups = {Update.class})
    private Long id;

    @NotNull(message = "年龄不能为空", groups = {Add.class, Update.class})
    @Max(value = 35, message = "年龄不超过35", groups = {Add.class, Update.class})
    @Min(value = 18, message = "年龄不小于18", groups = {Add.class, Update.class})
    private Integer age;

    //这两个接口可以继承default  只要加了NotNull注解的，就都会生效。
    //不建议继承Default

}
