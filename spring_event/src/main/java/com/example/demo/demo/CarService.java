package com.example.demo.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author yixuan.zhu
 * @Description //TODO 物流服务
 * @Date 2021/6/30 10:57
 **/
@Service
public class CarService implements ApplicationListener<OrderSuccessEvent> {
    @Override
    public void onApplicationEvent(OrderSuccessEvent orderSuccessEvent) {
        this.dispatch();
    }

    private void dispatch() {
        System.out.println("发车咯...");
    }


}
