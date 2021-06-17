package com.example.extendsDemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericClassDemo2 {

    public static void main(String[] args) {
        //Integer 是Number的子类
        List<Integer> integerList = new ArrayList<>(Arrays.asList(11,22));
        print(integerList);

        List<? extends Number> a = integerList;


        List<Integer> b = (List<Integer>) a;
    }

    public static void print(List<? extends Number> list){

    }
}
