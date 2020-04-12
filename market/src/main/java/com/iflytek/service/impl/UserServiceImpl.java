package com.iflytek.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.iflytek.dao.UserDao;
import com.iflytek.enity.User;
import com.iflytek.service.UserService;
import com.iflytek.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Result login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        User u = userDao.selectOne(wrapper);
        if (u != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            request.getSession().setAttribute("userId", u.getId());
            return Result.build(200,"登录成功",u);
        }
        return Result.build(500,"登录失败");
    }

    @Override
    public Result register(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        int exist = userDao.selectCount(wrapper);
        if(exist > 0){
            return Result.build(500,"用户名已存在~");
        }
        int count = userDao.insert(user);
        if(count > 0){
            return Result.build(200,"注册成功");
        }
        return Result.build(500,"注册失败");
    }

    @Override
    public Result getProfile(Integer id) {
        User user = userDao.selectById(id);
        if(user != null){
            return Result.build(200,"获取成功",user);
        }
        return Result.build(500,"获取失败");
    }

    @Override
    public Result editProfile(User user) {
        int count = userDao.updateById(user);
        if(count > 0){
            return Result.build(200,"修改成功");
        }
        return Result.build(500,"修改失败");
    }

    @Override
    public Result setPwd(User user, String oldPwd) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", user.getId());
        wrapper.eq("password", oldPwd);
        wrapper.set("password", user.getPassword());
        userDao.update(user,wrapper);
        int count = userDao.updateById(user);
        if(count > 0){
            return Result.build(200,"修改成功");
        }
        return Result.build(500,"修改失败");
    }


}
