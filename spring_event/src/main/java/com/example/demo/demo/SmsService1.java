package com.example.demo.demo;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 短信服务，监听OrderSuccessEvent，但不用实现ApplicationListener
 */
@Service
public class SmsService1 {

    /**
     * @Author yixuan.zhu
     * @Description //TODO 发送短信，@EventListener指定监听的事件
     * @Date 2021/6/30 10:59
     **/
    @EventListener(OrderSuccessEvent.class)
    public void sendSms(){
        try {
            Thread.sleep(1000L * 5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("发送短信");
    }
}
