package com.example.demo.Test;

import com.example.demo.service.Calculator;
import com.example.demo.service.impl.CalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest7 {

    public static void main(String[] args) {
        // 1.得到目标对象
        CalculatorImpl target = new CalculatorImpl();
        // 2.传入目标对象，得到增强对象（如果需要对目标对象进行别的增强，可以另外编写getXxInvocationHandler）
        InvocationHandler logInvocationHandler = getLogInvocationHandler(target);
        // 3.传入目标对象+增强代码，得到代理对象（直接用JDK的方法！！！）
        Calculator calculatorProxy = (Calculator) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),   // 随便传入一个类加载器
                target.getClass().getInterfaces(),    // 需要代理的接口
                logInvocationHandler                  // 增强对象（包含 目标对象 + 增强代码）

        );
    }



    /**
     * 日志增强代码
     *
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
