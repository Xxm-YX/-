package com.example.extendsDemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class GenericClassDemo {

    public static void main(String[] args) {
        ArrayList<Chinese> chineseArrayList = new ArrayList<>();
        chineseArrayList.add(new Chinese("李健"));
        chineseArrayList.add(new Chinese("周深"));

        ArrayList<Japanese> japaneseArrayList = new ArrayList<>();
        japaneseArrayList.add(new Japanese("三浦春马"));
        japaneseArrayList.add(new Japanese("瑛太"));

        /**
         * 与编译器约定，左右两边类型不一致也能赋值，但是有条件：
         * 右边List的参数类型必须是Human的子类
         */
        List<? extends Human> humanList = chineseArrayList;
        Human lee = humanList.get(0);
        Human chou = humanList.get(1);

//        humanList.add(new Person("aaa"));


        System.out.println(lee + "&" + chou);

        humanList = japaneseArrayList;
        Human haRuMa = humanList.get(0);
        Human eiTa = humanList.get(1);
        System.out.println(haRuMa + "&" + eiTa);

        List<Human> humans = new ArrayList<>();
        humans.addAll(chineseArrayList);

    }


    static class Person {
        private String age;
    }

    @AllArgsConstructor
    @Data
    static class Human extends Person{
        private String name;
    }

    public static class Chinese extends Human {
        public Chinese(String name) {
            super(name);
        }
    }

    public static class Japanese extends Human {
        public Japanese(String name) {
            super(name);
        }
    }
}
