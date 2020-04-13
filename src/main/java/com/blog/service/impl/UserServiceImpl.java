package com.blog.service.impl;

import com.blog.dao.UserRepository;
import com.blog.domain.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 神州战神
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user  = userRepository.findByUsernameAndPassword(username,password);
        return user;
    }
}
