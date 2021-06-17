package com.example.jpa;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class JpaTest {
    public static void main(String[] args) {
        new B();
    }
}

class A<T>{
    public A(){
        //这里的 ？ 参数 可能是A 也可能是 A的子类
        Class<? extends A> subClass = this.getClass();
        //子类Class获取泛型父类Class，相当于拿到整个 A<String>
        // 得到泛型父类
        Type genericSuperclass = subClass.getGenericSuperclass();

        //本质是ParameterizedTypeImpl 可以向下强转
        ParameterizedType parameterizedTypeSuperclass = (ParameterizedType) genericSuperclass;

        // 强转后可用的方法变多了，比如getActualTypeArguments()可以获取Class A<String>的泛型的实际类型参数
        Type[] actualTypeArguments = parameterizedTypeSuperclass.getActualTypeArguments();

        //由于A类只有一个泛型，这里可以直接通过actualTypeArguments[0]得到子类传递的实际类型参数
        Class actualTypeArgument = (Class)actualTypeArguments[0];

        System.out.println(actualTypeArgument);
        System.out.println(subClass.getTypeName());


        //得到泛型父类的class对象。
        System.out.println(genericSuperclass);
        System.out.println(genericSuperclass.getClass());
        System.out.println(subClass.getTypeName());

    }
}

class B extends A<String>{

}

class C extends A<Integer>{

}
