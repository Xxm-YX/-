package com.example.demo.test;

import com.example.demo.demo.OrderService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private OrderService orderService;

    @org.junit.Test
    public void testSpringEvent(){
            orderService.order();
    }
}
