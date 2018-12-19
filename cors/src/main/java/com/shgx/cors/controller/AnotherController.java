package com.shgx.cors.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 其他Controller
 *
 * @author guangxush
 */
@RestController
@RequestMapping("/another")
public class AnotherController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello() {
        return "another hello world!";
    }

}
