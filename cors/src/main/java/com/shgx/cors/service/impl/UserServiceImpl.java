package com.shgx.cors.service.impl;

import com.shgx.cors.model.User;
import com.shgx.cors.repository.UserRepo;
import com.shgx.cors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户信息操作
 *
 * @author guangxush
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public String findUserNameById(Long id) {
        return userRepo.findUserNameById(id);
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Override
    public User findUserById(Long id){
        Optional<User> users = userRepo.findById(id);
        User user = new User();
        if (users.isPresent()) {
            user.setId(users.get().getId());
            user.setAge(users.get().getAge());
            user.setName(users.get().getName());
            user.setSex(users.get().getSex());
        }
        return user;
    }
}
