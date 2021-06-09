package com.example.anno;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 封装结果集注解
 */
@RestController
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CosmoController {
}
