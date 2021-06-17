package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil2 {

    public ThreadLocalUtil2() {
    }


    private final static ThreadLocal<Map<String,Object>> THREAD_CONTEXT = new MapThreadLocal();

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public static Object get(String key){
        return getContextMap().get(key);
    }

    /**
     * put操作，原理同上
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        getContextMap().put(key, value);
    }

    /**
     * 清楚map中的某个值
     * @param key
     * @return
     */
    public static Object remove(String key) {
        return getContextMap().remove(key);
    }

    /**
     * 清空整个Map，这里是调用map的clear方法，
     */
    public static void remove(){
        getContextMap().clear();
    }

    /**
     * 从ThreadLocalMap中清除当前ThreadLocal存储的内容
     */
    public static void clear(){
        THREAD_CONTEXT.remove();
    }

    private static Map<String, Object> getContextMap() {
        return THREAD_CONTEXT.get();
    }


    /**
     * 内部类，继承自ThreadLocal，和第一版一样，仍旧指定value为Map<String,Object>
     * 之所以要自定义MapThreadLocal，是为了重写原生ThreadLocal的initialValue()
     * 把ThreadLocal第一版中判断null的操作隐藏掉，让代码优雅一点
     */
    private static class MapThreadLocal extends ThreadLocal<Map<String,Object>>{
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
}
