package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.enity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao extends BaseMapper<Admin> {
}
