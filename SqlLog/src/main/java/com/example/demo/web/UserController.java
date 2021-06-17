package com.example.demo.web;

import com.example.demo.DTO.Result;
import com.example.demo.DTO.User;
import com.example.demo.DTO.ValidationList;
import com.example.demo.anno.UserLog;
import com.example.demo.enums.ModuleEnum;
import com.example.demo.enums.OperationEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @UserLog(module = ModuleEnum.USER, title = "批量更新用户", type = OperationEnum.MODIFY)
    @PostMapping("updateBatchUser")
    public Result<Boolean> updateBatchUser(@Validated @RequestBody ValidationList<User> userList) {
        return Result.success(null);
    }

    @UserLog(module = ModuleEnum.USER, title = "新增用户", type = OperationEnum.ADD)
    @PostMapping("insertUser")
    public Result<Boolean> insertUser(@RequestBody User user) {
        return Result.success(null);
    }

}