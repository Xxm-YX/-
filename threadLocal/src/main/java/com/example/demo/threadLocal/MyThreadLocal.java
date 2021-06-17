package com.example.demo.threadLocal;

public class MyThreadLocal {

    private MyThreadLocal() {}

    private static final ThreadLocal<Object> THREAD_CONTEXT = new ThreadLocal<>();

    public static void put(Object obj){
        THREAD_CONTEXT.set(obj);
    }

    public static Object get(){
        return THREAD_CONTEXT.get();
    }

    public static void remove(){
        THREAD_CONTEXT.remove();
    }
}
