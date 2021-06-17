package com.example.demo.Test;

import com.example.demo.service.Calculator;
import com.example.demo.service.impl.CalculatorImpl;

import java.lang.reflect.*;

public class ProxyTest4 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CalculatorImpl target = new CalculatorImpl();
        //传入目标对象
        Calculator calculatorProxy = (Calculator) getProxy(target);
        calculatorProxy.add(1,2);
    }

    /**
     * 传入目标对象，获取代理对象
     * @param target
     * @return
     */
    private static Object getProxy(final Object target) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //参数1：随便找个类加载器给它，参数2：需要代理的接口
        Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        //获取构造器
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        return constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行");
                Object result = method.invoke(target, args);
                System.out.println(result);
                System.out.println(method.getName() + "方法执行结束...");
                return result;
            }
        });
    }


}
