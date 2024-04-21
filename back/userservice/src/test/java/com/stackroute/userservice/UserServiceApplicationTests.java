package com.stackroute.userservice;


import com.stackroute.userservice.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {UserServiceApplication.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceApplicationTests {

    @Test
    public void contextLoads() {
    }

}
