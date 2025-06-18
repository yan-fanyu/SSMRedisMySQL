package com.opencode.demo.service;

import com.opencode.demo.mapper.UserMapper;
import com.opencode.demo.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    public User queryById(Integer id);
}
