package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.iflytek.enity.Order;
import com.iflytek.enity.Orderv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    @Select("select * from sys_order  where user_id = #{id} order by time desc")
    List<Orderv> getOrderListByUserId(Integer id);

    @Select("select * from sys_order order by time desc")
    List<Orderv> getOrderList();

    @Select("select * from sys_order where id like #{id} and address like #{address} order by time desc")
    List<Orderv> getOrderListByKeywords(String id,String address);
}
