package com.example.demo.config;

import com.example.demo.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


/**
 * @Author yixuan.zhu
 * @Description //TODO 容器启动线程
 * @Date 2021/6/30 13:49
 **/
@Slf4j
@Component
public class RedisMessageQueueConsumer implements ApplicationRunner {

    @Autowired
    private RedisService redisService;
    public static final String ORDER_MESSAGE = "order_message";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("SpringBoot项目启动了...");

        CompletableFuture.runAsync(() ->{
            while(true){
                Object order = redisService.popQueue(ORDER_MESSAGE, 5L, TimeUnit.SECONDS);
                log.info("每隔5秒循环获取，期间for循环阻塞");
                if (order != null) {
                    log.info("从队列取出一条消息, order:{}", order.toString());
                }
            }
        });

    }
}
