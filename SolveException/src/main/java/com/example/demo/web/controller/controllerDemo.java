package com.example.demo.web.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.Exception.BizException;
import com.example.demo.domain.MpUserPojo;
import com.example.demo.domain.Result;
import com.example.demo.enumTO.ExceptionCodeEnum;
import com.example.demo.service.MpUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class controllerDemo {

    @Autowired
    private MpUserService mpUserService;

    @PostMapping("insertUser")
    public Result<Boolean> insertUser(@RequestBody MpUserPojo userPojo) {
        if (userPojo == null) {
            // 只传入定义好的错误
            return Result.error(ExceptionCodeEnum.EMPTY_PARAM);
        }
        if (userPojo.getUserType() == null) {
            // 抛出自定义的错误信息
            return Result.error(ExceptionCodeEnum.ERROR_PARAM, "userType不能为空");
        }
        if (userPojo.getAge() < 18) {
            // 抛出自定义的错误信息
            return Result.error("年龄不能小于18");
        }
        try {
         return Result.success(mpUserService.save(userPojo));
        } catch (Exception e) {
            log.warn("userService rpc failed, request:{}", JSON.toJSONString(userPojo), e);
            return Result.error(ExceptionCodeEnum.ERROR);
        }
    }

    /**
     * 一般来说，全局异常处理只是一种兜底的异常处理策略，也就是说提倡自己处理异常。
     * 但现在其实很多人都喜欢直接在代码中抛异常，全部交给@RestControllerAdvice处理
     * @param userPojo
     * @return
     */
    @PostMapping("insertUser1")
    public Result<Boolean> insertUser1(@RequestBody MpUserPojo userPojo) {
        if (userPojo == null) {
            throw new BizException(ExceptionCodeEnum.EMPTY_PARAM);
        }

        return Result.success(mpUserService.save(userPojo));
    }

    @PostMapping("insertUser2")
    public Result<Boolean> insertUser2(@RequestBody MpUserPojo userPojo) {
        if (userPojo == null) {
            throw new BizException(ExceptionCodeEnum.EMPTY_PARAM);
        }

        return Result.success(mpUserService.save(userPojo));
    }
}
