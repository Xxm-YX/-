package com.example.demo.demo;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.springframework.context.ApplicationEvent;

/**
 * @Author yixuan.zhu
 * @Description //TODO 自定义事件
 * @Date 2021/6/30 11:27
 **/
public class OrderSuccessEvent extends ApplicationEvent {

    public OrderSuccessEvent(Object source) {
        super(source);
    }
}
