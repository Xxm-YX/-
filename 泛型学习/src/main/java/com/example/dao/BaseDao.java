package com.example.dao;

public class BaseDao<T> {

    public T get(T t){
        return t;
    }

    /**
     * 泛型方法：无返回值，所以是void，<E> 出现在返回值前，表示声明E变量
     * @param e
     * @param <E>
     */
    public <E> void methodWithoutReturn(E e){

    }

    /**
     * 泛型方法，有返回值。入参和返回值都是V，注意，即使这个用E  也和上面的E 没有关系
     * @param v
     * @param <V>
     * @return
     */
    public <V> V methodWithReturn(V v){
        return v;
    }
}
