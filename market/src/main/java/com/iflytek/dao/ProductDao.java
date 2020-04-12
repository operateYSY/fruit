package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.enity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductDao extends BaseMapper<Product> {

    @Select("select distinct sort from sys_product where state=1")
    List<String> getAllSort();

    @Select("select * from sys_product where id=#{id} ")
    List<Product> getListById(Integer id);
}
