package com.shgx.web.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 请求外部链接， 私有的
 *
 * @author guangxush
 */
@RestController
public class NativeController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello(){
       return "hello world!";
    }

}
