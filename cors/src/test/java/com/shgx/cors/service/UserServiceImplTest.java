package com.shgx.cors.service;

import com.shgx.cors.CorsApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CorsApplication.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void findUserByIdTest(){
        String name = userService.findUserNameById(1L);
        System.out.println(name);
        Assert.assertNotNull(name);
    }
}
