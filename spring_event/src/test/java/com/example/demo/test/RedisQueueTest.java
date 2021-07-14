package com.example.demo.test;

import com.example.demo.redis.RedisService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisQueueTest {

    @Autowired
    private RedisService redisService;

    public static final String ORDER_MESSAGE = "order_message";

    @Test
    public void testRedisBlocakingQueue() throws InterruptedException {
        //订单服务
        orderService("zyx",10086L);

        //启动消费者，取出消息，逐一发送
//        new Thread(this::consumeMs).start();

        TimeUnit.SECONDS.sleep(1);
        orderService("xxm",99999L);

        //等一会 看第二条消息
        TimeUnit.SECONDS.sleep(10);
    }

    private void consumeMs() {

        while(true){
            Object order = redisService.popQueue(ORDER_MESSAGE, 5L, TimeUnit.SECONDS);
            log.info("每隔5秒循环获取，期间for循环阻塞");
            if(order != null){
                log.info("order:{}", order.toString());
            }
            log.info("循环完一次");
        }
    }

    private void orderService(String username, Long orderId) {
        //1.操作数据库，插入订单

        //2.其他操作

        //3.发送消息
        redisService.pushQueue(ORDER_MESSAGE, new Order(username,orderId));
    }


    @Data
    @AllArgsConstructor
    static class Order {
        private String username;
        private Long resumeId;
    }

}
