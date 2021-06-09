package com.example.utils;

import org.springframework.util.Assert;

public class SpringAssertTest {

    /**
     * Spring提供的Assert工具类，可以指定IllegalArgumentException 的 message
     * @param args
     */
    public static void main(String[] args) {
        String name = "" ;
//        Assert.hasText(name,"名字不能为空");

        Integer age = null;
//        Assert.notNull(age, "年龄不能为空");

        Integer height = 180;
        Assert.isTrue(height > 185, "身高不能低于185");
    }
}
