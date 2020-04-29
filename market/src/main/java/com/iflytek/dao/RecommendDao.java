package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.enity.Recommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecommendDao extends BaseMapper<Recommend> {

}
