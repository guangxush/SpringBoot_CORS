package com.shgx.web.service;

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

    public String fetchAnotherUrl(String uid){
        RestTemplate restTemplate = builder.build();
        String requestUrl = request+uid;
        String response = "";
        try{
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(requestUrl, String.class);
            if(responseEntity.getStatusCode()== HttpStatus.OK){
                response = responseEntity.getBody();
                //responseEntity = response.getData();
            }
            return response;
        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
    }



}
