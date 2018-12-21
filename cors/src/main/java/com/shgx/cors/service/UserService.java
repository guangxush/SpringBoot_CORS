package com.shgx.cors.service;


import com.shgx.cors.model.User;

/**
 * 用户信息获取
 *
 * @author guangxush
 */
public interface UserService {
    /**
     * 根据id获取用户姓名
     * @param id
     * @return
     */
    String findUserNameById(Long id);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User findUserById(Long id);
}
