package com.example.demo.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author yixuan.zhu
 * @Description //TODO 短信服务，监听OrderSuccessEvent
 * @Date 2021/6/30 10:53
 **/
@Service
public class SmsService implements ApplicationListener<OrderSuccessEvent> {
    
    @Override
    public void onApplicationEvent(OrderSuccessEvent orderSuccessEvent) {
        this.sendSms();
    }

    /**
     * @Author yixuan.zhu
     * @Description //TODO 发送短信
     * @Date 2021/6/30 10:53
     **/
    private void sendSms() {
        System.out.println("发送短信...");
    }
}
