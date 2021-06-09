package com.example.utils;

import com.example.exception.ValidatorException;

import javax.xml.bind.ValidationException;

/**
 * 结合@RestControllerAdvice 进行全局异常处理
 */
public class ValidatorUtils {

    public ValidatorUtils() {
    }

    // 错误信息模板
    private static final String IS_EMPTY = "%s不能为空";
    private static final String LESS_THAN_ZERO = "%s不能小于0";

    /**
     * 校验参数是否为null
     */
    public static void checkNull(Object param,String fieldName){
        if(param == null){
            // ValidatorException是自定义异常
            throw new ValidatorException(String.format(IS_EMPTY,fieldName));
        }
    }

    /**
     * 校验id是否合法
     *
     * @param id
     * @param fieldName
     */
    public static void checkId(Long id, String fieldName) {
        if (id == null) {
            throw new ValidatorException(String.format(IS_EMPTY, fieldName));
        }
        if (id < 0) {
            throw new ValidatorException(String.format(LESS_THAN_ZERO, fieldName));
        }
    }
}
