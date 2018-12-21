package com.shgx.web.service;


import com.shgx.web.WebApplication;
import com.shgx.web.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class RequestAnotherServiceTest {

    @Autowired
    private RequestAnotherService service;


    @Test
    public void fetchAnotherUrlTest(){
        Long uid = 1L;
        User user = service.fetchAnotherUrl(uid);
        Assert.assertEquals(uid,user.getId());
    }
}
