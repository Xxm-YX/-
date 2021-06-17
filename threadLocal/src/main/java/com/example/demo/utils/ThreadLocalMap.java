package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalMap extends ThreadLocal<Map<String,Object>>{

    public ThreadLocalMap() {
    }

    private final static ThreadLocal<Map<String,Object>> THREAD_CONTEXT = new ThreadLocalMap();

    /**
     * 根据key获取value
     * @return
     */
    public static Object get(String key){
        /**
         *  getContextMap()表示要先获取THREAD_CONTEXT的value，
         *  也就是Map<String, Object>。然后再从Map<String, Object>中根据key获取
         */
        return THREAD_CONTEXT.get().get(key);
    }

    /**
     * put操作，原理同上
     * @param key
     * @param value
     */
    public static void put(String key,Object value){
        THREAD_CONTEXT.get().put(key,value);
    }

    /**
     * 清除map中的某个值
     * @return
     */
    public static Object remove(String key){
        return THREAD_CONTEXT.get().remove(key);
    }

    /**
     * 清空整个Map<String,Object>
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

    @Override
    protected Map<String, Object> initialValue() {
        return new HashMap<String,Object>(8){
            private static final long serialVersionUID = 3637958959138295593L;

            @Override
            public Object put(String key, Object value) {
                return super.put(key, value);
            }
        };
    }
}
