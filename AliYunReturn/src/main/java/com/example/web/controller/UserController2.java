package com.example.web.controller;

import com.example.domain.Result;
import com.example.domain.User;
import com.example.domain.User2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Slf4j
@Validated
@RestController
public class UserController2 {

    @GetMapping("getUser4")
    public Result<User> getUser(@NotNull(message = "部门id不能为空") Long departmentId,
                                @NotNull(message = "年龄不能为空")
                                @Max(value = 35,message = "年龄不能超过35")
                                @Min(value = 18,message = "年龄不能小于18") Integer age){
        return Result.success(null);
    }

    /**
     * 如果都是用DTO包装参数，那么Controller可以不加@Validated（但建议还是都加上吧）
     * 参数列表里用@Validated或@Valid都可以
     *
     * @param user
     * @return
     */
    @GetMapping("getUser5")
    public Result<User> getUser(@Validated User2 user) {
        System.out.println("进来了");
        return Result.success(null);
    }


    /**
     * 嵌套校验
     * @param user
     * @return
     */
    @PostMapping("updateUser2")
    public Result<Boolean> updateUser(@Validated @RequestBody User2 user) {
        System.out.println("进来了");
        return Result.success(null);
    }


}
