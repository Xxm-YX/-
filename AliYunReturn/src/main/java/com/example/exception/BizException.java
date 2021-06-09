package com.example.exception;


import com.example.domain.ExceptionCodeEnum;
import lombok.Getter;

/**
 * 业务异常
 */
@Getter
public class BizException extends RuntimeException{

    private ExceptionCodeEnum error;

    /**
     * 构造器，有时我们需要将第三方异常转为自定义异常抛出，但又不想丢失原来的异常信息
     * 此时可以传入cause
     * @param cause
     * @param error
     */
    public BizException(Throwable cause, ExceptionCodeEnum error) {
        super(cause);
        this.error = error;
    }

    /**
     * 构造器只传入错误枚举
     * @param error
     */
    public BizException(ExceptionCodeEnum error){
        this.error = error;
    }


}
