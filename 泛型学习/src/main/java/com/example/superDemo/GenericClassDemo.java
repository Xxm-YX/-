package com.example.superDemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * List<? super Human>接收：只能指向父类型List，比如List<Creature>、List<Primate>
 * List<? super Human>取出：只能转Object（WHY）
 * List<? super Human>存入：只能存Human及其子类型元素（WHY）
 */
public class GenericClassDemo {

    public static void main(String[] args) {
        List<? super Human> humanList = new ArrayList<>();

        humanList.add(new Human("人类"));

        //只能指向Human及其父类型的List:灵长类、生物类
        // humanList = new ArrayList<Chinese>(); // ERROR
        humanList = new ArrayList<Primate>();
        humanList = new ArrayList<Creature>();

        // 哇，牛逼啊，简单泛型和extends都搞不定的存入问题让你super整得服服帖帖
        humanList.add(new Human("女性"));
        humanList.add(new Chinese("中国人"));

        // super：也不是啦，我虽然能存东西，但规定只能存Human及其子类型元素
//        humanList.add(new Primate("灵长类动物")); // ERROR
//        humanList.add(new Creature("外星生物")); // ERROR
//        humanList.add("无关类型，比如String"); // ERROR

        // 简单类型&extends：哈哈哈，你这啥玩意，怎么只能往Object自动转型
        Human object = (Human) humanList.get(0);
        System.out.println(object.toString());

    }

    static class Creature {
        public Creature(String name) {
            this.name = name;
        }
        private String name;
    }

    static class Primate extends Creature { //造物主
        public Primate(String name) {
            super(name);
        }
    }

    static class Human extends Primate {//灵长类动物
        public Human(String name) {
            super(name);
        }
    }

    static class Chinese extends Human {
        public Chinese(String name) {
            super(name);
        }
    }

    static class Japanese extends Human {
        public Japanese(String name) {
            super(name);
        }
    }
}
