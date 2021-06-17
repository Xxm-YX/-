package com.example.web.controller;

import com.example.aspect.ApiLog;
import com.example.domain.Result;
import com.example.domain.User;
import com.example.valid.ValidationList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Slf4j
@Validated
@RestController
public class UserController4 {

    @GetMapping("getUser10")
    public User getUser(@NotNull(message = "id不能为空") Long id) {
        test();
        return null;
    }

    private void test(){
        System.out.println("test");
    }

    /**
     * 给需要打印日志的接口方法加@ApiLog
     * @param userList
     * @return
     */
    @ApiLog
    @PostMapping("updateBatchUser10")
    public Result<Boolean> updateBatchUser(@Validated @RequestBody ValidationList<User> userList) {
        System.out.println(userList);
        return Result.success(null);
    }

    @GetMapping("/DB/{a}")
    public void a(@PathVariable("a") UUID a){
        System.out.println(a);
    }
}