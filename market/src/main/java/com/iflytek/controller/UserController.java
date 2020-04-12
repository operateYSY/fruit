package com.iflytek.controller;

import com.iflytek.enity.User;
import com.iflytek.service.UserService;
import com.iflytek.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public Result login(User user){
        return userService.login(user);
    }

    @ResponseBody
    @PostMapping("/register")
    public Result register(User user){
        return userService.register(user);
    }

    @ResponseBody
    @PostMapping("/getProfile")
    public Result getProfile(Integer id){
        return userService.getProfile(id);
    }

    @ResponseBody
    @PostMapping("/editProfile")
    public Result editProfile(User user){
        return userService.editProfile(user);
    }

    @ResponseBody
    @PostMapping("/setPwd")
    public Result setPwd(User user,String oldPwd){
        return userService.setPwd(user,oldPwd);
    }




}
