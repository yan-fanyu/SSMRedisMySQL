package com.opencode.demo.service.impl;

import com.opencode.demo.mapper.UserMapper;
import com.opencode.demo.pojo.User;
import com.opencode.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }
}
