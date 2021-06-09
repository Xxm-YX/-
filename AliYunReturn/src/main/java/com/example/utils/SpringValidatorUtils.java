package com.example.utils;

import com.example.exception.ValidatorException;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class SpringValidatorUtils {

    private SpringValidatorUtils(){}

    /**
     * 校验器
     */
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 校验参数
     *
     * @param param  待校验的参数
     * @param groups 分组校验，比如Update.class（可以不传）
     * @param <T>
     */
    public static <T> void validate(T param,Class<?>... groups){
        Set<ConstraintViolation<T>> validateResult = validator.validate(param, groups);

        if (!CollectionUtils.isEmpty(validateResult)) {
            StringBuilder validateMessage = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : validateResult) {
                validateMessage.append(constraintViolation.getMessage()).append(" && ");
            }
            // 去除末尾的 &&
            validateMessage.delete(validateMessage.length() - 4, validateMessage.length());
            // 抛给全局异常处理
            throw new ValidatorException(validateMessage.toString());
        }
    }
}
