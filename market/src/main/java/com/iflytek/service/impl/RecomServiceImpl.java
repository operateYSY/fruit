package com.iflytek.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iflytek.config.Result;
import com.iflytek.dao.ProductDao;
import com.iflytek.dao.RecommendDao;
import com.iflytek.enity.Product;
import com.iflytek.enity.Recommend;
import com.iflytek.service.RecomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomServiceImpl implements RecomService {
    @Autowired
    RecommendDao recommendDao;
    @Autowired
    ProductDao productDao;

    @Override
    public Result search(int state, String sort) {
        QueryWrapper<Recommend> wrapper = new QueryWrapper<>();
        wrapper.eq("state", state);
        if (!"".equals(sort) && sort != null) {
            wrapper.eq("sort", sort);
        }
        List<Recommend> list = recommendDao.selectList(wrapper);
        if (list != null) {
            return Result.build(200, "查询成功", list);
        }
        return Result.build(500, "查询失败");
    }

    @Override
    public Result all() {

        List<Product> list1 = productDao.selectList(null);
        return Result.build(200, "查询成功", list1);
    }
}


