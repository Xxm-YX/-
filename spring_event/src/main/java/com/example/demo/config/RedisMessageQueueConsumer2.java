package com.example.demo.config;

import com.example.demo.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author yixuan.zhu
 * @Description //TODO 监听器 容器启动完毕后 启动消费者线程
 * @Date 2021/6/30 13:47
 **/
@Slf4j
public class RedisMessageQueueConsumer2 implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RedisService redisService;

    public static final String ORDER_MESSAGE = "order_message";
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("开始监听RedisMessageQueue...");
        CompletableFuture.runAsync(() -> {
            while (true) {
                Object order = redisService.popQueue(ORDER_MESSAGE, 5L, TimeUnit.SECONDS);
                log.info("每隔5秒循环获取，期间for循环阻塞");
                if (order != null) {
                    log.info("从队列取出一条消息, order:{}", order.toString());
                }
            }
        });
    }
}
