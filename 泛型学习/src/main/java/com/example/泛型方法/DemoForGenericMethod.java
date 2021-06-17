package com.example.泛型方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoForGenericMethod {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> stringList = reverseList(list);
        System.out.println(stringList);
    }

    /**
     * 静态的泛型方法，出现在一个普通类
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> reverseList(List<T> list){
        List<T> newList = new ArrayList<>();
        for (int i = list.size()-1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
