package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.enity.Recommend;
import com.iflytek.enity.RecommendView;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommendDao extends BaseMapper<Recommend> {

}
