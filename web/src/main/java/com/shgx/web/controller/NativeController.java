package com.shgx.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class NativeController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello(){
       return "hello world!";
    }

}
