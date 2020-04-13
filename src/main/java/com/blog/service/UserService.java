package com.blog.service;

import com.blog.domain.User;

public interface UserService {
    /**
     * 检查用户登录方法
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username,String password);
}
