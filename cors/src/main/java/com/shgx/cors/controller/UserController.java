package com.shgx.cors.controller;

import com.shgx.cors.model.User;
import com.shgx.cors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息操作
 *
 * @author guangxush
 */
@RestController
@RequestMapping("/open")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String getTokenOnlyFromDB(@PathVariable(value = "userId") Long userId) {
        String name = userService.findUserNameById(userId);
        if (name != null) {
            return "{\"data\":\"" + name + "\"}";
        } else {
            return "{\"data\":\"" + "no user" + "\"}";
        }
    }


    @RequestMapping(value = "/user_info/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "userId") Long userId){
        User user = userService.findUserById(userId);
        return user;
    }
}
