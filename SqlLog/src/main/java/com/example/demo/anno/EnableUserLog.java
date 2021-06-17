package com.example.demo.anno;

import com.example.demo.aspect.UserLogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启用户日志记录（还需要在相关方法上添加{@link UserLog}）
 */

@Import(UserLogAspect.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableUserLog {
}
