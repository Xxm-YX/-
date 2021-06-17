package com.example.demo.Test;

import com.example.demo.service.Calculator;
import com.example.demo.service.impl.CalculatorImpl;

import java.lang.reflect.*;

public class ProxyTest3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /**
         * 参数1：类加载器 随便给一个
         * 参数2：需要生成代理Class的接口 比如Calculator
         */
        Class<?> calculatorProxyClazz  = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);

        //得到唯一的有参构造，$Proxy(InvocationHandler h) 和 反射的Method有点像，
        //可以理解为对应的构造器执行器
        Constructor<?> constructors = calculatorProxyClazz.getConstructor(InvocationHandler.class);

        //用构造器执行器执行构造方法，得到代理对象，构造器需要InvocationHandler入参
        Calculator calculatorProxyImpl = (Calculator) constructors.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //最low方案，手动new一个目标对象
                CalculatorImpl calculator = new CalculatorImpl();
                System.out.println(method.getName() + "方法开始执行。。。");
                //反射执行目标对象方法
                Object result = method.invoke(calculator, args);
                //执行方法后打印日志
                System.out.println(result);
                System.out.println(method.getName()+"方法结束");

                return result;
            }
        });

        System.out.println(calculatorProxyImpl.subtract(1,2));
    }
}
