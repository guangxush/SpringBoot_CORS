package com.shgx.cors.repository;

import com.shgx.cors.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户数据库操作类
 *
 * @author guangxush
 */
public interface UserRepo extends JpaRepository<User, Long> {

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    @Query(value = "select name from tb_user where id =?1", nativeQuery = true)
    String findUserNameById(Long id);
}
