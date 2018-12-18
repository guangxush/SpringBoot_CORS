package com.shgx.cors.service.impl;

import com.shgx.cors.model.User;
import com.shgx.cors.repository.UserRepo;
import com.shgx.cors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
