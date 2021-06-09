package com.example.demo.web.Handler;

import com.example.demo.Exception.BizException;
import com.example.demo.domain.Result;
import com.example.demo.enumTO.ExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(BizException.class)
    public Result<ExceptionCodeEnum> handleBizException(BizException bizException){
        log.error("业务异常:{}", bizException.getMessage(), bizException);
        return Result.error(bizException.getError());
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<ExceptionCodeEnum> handleRunTimeException(RuntimeException e) {
        log.error("运行时异常: {}", e.getMessage(), e);
        return Result.error(ExceptionCodeEnum.ERROR);
    }
}
