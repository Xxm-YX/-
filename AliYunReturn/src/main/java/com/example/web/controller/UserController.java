package com.example.web.controller;

import com.example.anno.CosmoController;
import com.example.anno.IgnoreCosmoResult;
import com.example.domain.ExceptionCodeEnum;
import com.example.domain.Result;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.ValidatorUtils;
import com.example.utils.ValidatorUtils2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
@CosmoController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(Long id) {
        return userService.getById(id);
    }

    @IgnoreCosmoResult
    @GetMapping("/getUser2")
    public User getUser2(Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public Result<Boolean> insertUser(@RequestBody User user){
        if (user == null) {
            return Result.error(ExceptionCodeEnum.EMPTY_PARAM);
        }
        // 对校验结果进行判断并返回，也可以抛异常让@RestControllerAdvice兜底
        if (ValidatorUtils2.isNotId(user.getId())) {
            return Result.error("id为空或小于0");
        }

        return Result.success(userService.save(user));
    }


    @PostMapping("updateUser")
    public Result<Boolean> updateUser(@RequestBody User user){
        System.out.println(user);
        //一连串的校验
        ValidatorUtils.checkNull(user,"user");
        ValidatorUtils.checkId(user.getId(),"用户id");

        return Result.success(true);
    }
}
