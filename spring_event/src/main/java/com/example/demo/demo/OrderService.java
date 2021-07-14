package com.example.demo.demo;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author yixuan.zhu
 * @Description //TODO 订单服务
 * @Date 2021/6/30 10:47
 **/
@Service
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    public void order(){
        //下单成功
        System.out.println("下单成功...");
        //发布通知（传入了当前对象）
        applicationContext.publishEvent(new OrderSuccessEvent(this));
        System.out.println("main线程结束...");
    }
}
