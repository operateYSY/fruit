package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.enity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {


}
