package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalMap2 {

    public ThreadLocalMap2() {
    }

    /**
     * ThreadLocal的静态方法withInitial()会返回一个SuppliedThreadLocal对象
     * 而SuppliedThreadLocal<T> extends ThreadLocal<T>
     *    我们存进去的map会作为返回值
     *    protected T initialValue(){
     *        return supplier.get();
     *    }
     *
     *    所以也相当于重写了initialValue()
     */
    private final static ThreadLocal<Map<String,Object>> THREAD_CONTEXT = ThreadLocal.withInitial(
            () -> new HashMap<>(8)
    );

    /**
     * 根据key获取value
     */
    public static Object get(String key){
        return THREAD_CONTEXT.get().get(key);
    }

    /**
     * put操作，原理同上
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        THREAD_CONTEXT.get().put(key, value);
    }

    /**
     * 清除map中的某个值
     * @param key
     * @return
     */
    public static Object remove(String key) {
        return THREAD_CONTEXT.get().remove(key);
    }

    /**
     * 清除整个Map<String,Object>
     */
    public static void clear(){
        THREAD_CONTEXT.get().clear();
    }

    /**
     * 从ThreadLocalMap中清除当前ThreadLocal存储的内容
     */
    public static void clearAll(){
        THREAD_CONTEXT.remove();
    }
}
