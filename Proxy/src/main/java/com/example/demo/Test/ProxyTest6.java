package com.example.demo.Test;

import com.example.demo.service.Calculator;
import com.example.demo.service.impl.CalculatorImpl;

import java.lang.reflect.*;

public class ProxyTest6 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1.得到目标对象
        CalculatorImpl target = new CalculatorImpl();
        //2.传入目标对象，得到增强对象
        InvocationHandler logInvocationHandler = getLogInvocationHandler(target);
        //3.传入接口+增强对象（含目标对象），得到代理对象
        Calculator proxy = (Calculator) getProxy(
                logInvocationHandler,   //增强对象（包含 目标对象+增强代码）
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces()
        );
        proxy.add(1,2);
    }

    private static Object getProxy(final InvocationHandler handler,
                                   final ClassLoader classLoader,
                                   final Class<?>... interfaces ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 参数1：随便找个类加载器给它 参数2：需要代理的接口
        //获取代理Class对象
        Class<?> proxyClazz = Proxy.getProxyClass(classLoader, interfaces);
        //获取代理Class对象的构造方法
        Constructor<?> constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //使用构造方进行实例化
        return constructor.newInstance(handler);
    }

    /**
     * 日志增强代码
     * @param target
     * @return
     */
    private static InvocationHandler getLogInvocationHandler(final CalculatorImpl target) {
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy1, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行...");
                Object result = method.invoke(target, args);
                System.out.println(result);
                System.out.println(method.getName() + "方法执行结束...");
                return result;
            }
        };
    }
}
