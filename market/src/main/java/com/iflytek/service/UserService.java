package com.iflytek.service;

import com.iflytek.enity.User;
import com.iflytek.utils.Result;

public interface UserService {
    Result login(User user);

    Result register(User user);

    Result getProfile(Integer id);

    Result editProfile(User user);

    Result setPwd(User user, String oldPwd);
}
