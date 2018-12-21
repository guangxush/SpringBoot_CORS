package com.shgx.web.service;

import com.shgx.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 请求外部链接，公开的
 *
 * @author guangxush
 */
@Service
public class RequestAnotherService {

    @Value("${url.user}")
    private String request;

    @Autowired
    private RestTemplateBuilder builder;

    /**
     * 采用RestTemplate调用接口获取用户信息
     *
     * @param uid
     * @return
     */
    public User fetchAnotherUrl(Long uid){
        RestTemplate restTemplate = builder.build();
        String requestUrl = request+uid;
        User responseuser = null;
        try{
            ResponseEntity<User> responseEntity = restTemplate.getForEntity(requestUrl, User.class);
            if(responseEntity.getStatusCode()== HttpStatus.OK){
                responseuser = responseEntity.getBody();
            }
            return responseuser;
        } catch (Exception e) {
            System.out.println(e);
            //返回默认值
            responseuser = new User(2L,"normal",18,"boys");
        }
        return responseuser;
    }

}
