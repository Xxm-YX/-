package com.example.web.controller.advice;

import com.example.anno.CosmoController;
import com.example.anno.IgnoreCosmoResult;
import com.example.domain.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //对所有返回值起作用
//        return true;
        //对标注了@CosmoController注解的Controller返回值进行处理
        //methodParameter.getDeclaringClass()表示得到方法所在的类
//        return methodParameter.getDeclaringClass().isAnnotationPresent(CosmoController.class);

        // 标注了@CosmoController，且类及方法上都没有标注@IgnoreCosmoResult的方法才进行包装
        return methodParameter.getDeclaringClass().isAnnotationPresent(CosmoController.class)
                && !methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreCosmoResult.class)
                && !methodParameter.getMethod().isAnnotationPresent(IgnoreCosmoResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
// 改一行代码即可：把Object返回值用Result封装

        if(o instanceof Result){
            return o;
        }
        return Result.success(o);
//        return "mock result";
    }
}