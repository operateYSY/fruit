package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.iflytek.enity.Information;
import com.iflytek.enity.Order;
import com.iflytek.enity.Orderv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InformationDao extends BaseMapper<Information> {
    @Select("select * from sys_information  where sort = #{sort} order by time desc")
    List<Information> getInformationListBySort(String sort);

    @Select("select * from sys_information order by time desc")
    List<Information> getAllInformation();

    @Select("select  distinct sort from sys_information ")
    List<String> getAllSort();

    @Select("select * from sys_information  order by time desc limit #{index},#{num}")
    List<Information> getPageList(int index,int num);
}
