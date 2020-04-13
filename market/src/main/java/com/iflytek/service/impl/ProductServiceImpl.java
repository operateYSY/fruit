package com.iflytek.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iflytek.dao.ProductDao;
import com.iflytek.enity.Product;
import com.iflytek.service.ProductService;
import com.iflytek.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;



    @Override
    public Result list() {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("state", 1);
        List<Product> products = productDao.selectList(wrapper);
        return Result.build(200,"查询成功", products);
    }

    @Override
    public Result getOne(Product p) {
        Product product = productDao.selectById(p.getId());
        if(product != null){
            return Result.build(200,"查询成功", product);
        }
        return Result.build(500,"查询失败");
    }

    @Override
    public Result getAllSort() {
        List<String> list = productDao.getAllSort();
        return Result.build(200,"查询成功",list);
    }

    @Override
    public Result search(String keyword,String sort) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like("name", keyword);
        wrapper.eq("state", 1);
        if(!"".equals(sort) && sort!=null){
            wrapper.eq("sort", sort);
        }
        List<Product> products = productDao.selectList(wrapper);
        return Result.build(200,"查询成功", products);
    }


}
