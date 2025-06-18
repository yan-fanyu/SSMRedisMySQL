package com.opencode.demo.controller;

import com.opencode.demo.pojo.User;
import com.opencode.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id){
        User user = userService.queryById(id);
        System.out.println(user.getName());
        return user;
    }


}
