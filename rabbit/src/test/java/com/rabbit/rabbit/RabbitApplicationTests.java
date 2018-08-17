package com.rabbit.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void send() {
        System.out.println(564);
    }

}
