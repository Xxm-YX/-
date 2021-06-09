package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.web.interceptor.BizInterceptor;
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BizInterceptor()).addPathPatterns("/**")
                    //多加一个路径排除
                    .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/doc.html/**")
        ;
    }
}
