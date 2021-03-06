package com.example.demo.redis;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    /**
     * 向队列插入消息
     *
     * @param queue 自定义队列名称
     * @param obj   要存入的消息
     */
    void pushQueue(String queue, Object obj);

    /**
     * 从队列取出消息
     *
     * @param queue    自定义队列名称
     * @param timeout  最长阻塞等待时间
     * @param timeUnit 时间单位
     * @return
     */
    Object popQueue(String queue, Long timeout, TimeUnit timeUnit);

}
