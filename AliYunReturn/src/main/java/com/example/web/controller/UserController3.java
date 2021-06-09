package com.example.web.controller;

import com.example.domain.*;
import com.example.utils.SpringValidatorUtils;
import com.example.valid.Add;
import com.example.valid.Update;
import com.example.valid.ValidationList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController3 {

    @PostMapping("insertUser2")
    public Result<Boolean> insertUser(@Validated(Add.class) @RequestBody User3 user) {
        System.out.println("进来了");
        return Result.success(null);
    }

    @PostMapping("updateUser3")
    public Result<Boolean> updateUser(@Validated(Update.class) @RequestBody User3 user) {
        System.out.println("进来了");
        return Result.success(null);
    }

    @PostMapping("updateBatchUser")
    public Result<Boolean> updateBatchUser(@Validated @RequestBody ValidationList<User> userList) {
        System.out.println(userList);
        return Result.success(null);
    }

    @PostMapping("insertUser10")
    public Result<Boolean> insertUser5(@RequestBody User2 user) {
        System.out.println("aaaaa"+user);
        SpringValidatorUtils.validate(user);
        SpringValidatorUtils.validate(user.getDepartment());
        System.out.println("进来了");
        return Result.success(null);
    }

    @PostMapping("insertUser11")
    public Result<Boolean> insertUser6(@RequestBody User4 user) {
        System.out.println("aaaaa"+user);
        SpringValidatorUtils.validate(user,Update.class);
//        SpringValidatorUtils.validate(user);
        System.out.println("进来了");
        return Result.success(null);
    }

}
