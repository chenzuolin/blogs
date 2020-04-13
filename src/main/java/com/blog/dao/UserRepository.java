package com.blog.dao;

import com.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 神州战神
 */
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 通过用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username,String password);
}
