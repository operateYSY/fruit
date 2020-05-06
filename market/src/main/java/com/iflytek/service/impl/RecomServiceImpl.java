package com.iflytek.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iflytek.config.Result;
import com.iflytek.dao.ProductDao;
import com.iflytek.dao.RecommendDao;
import com.iflytek.dao.RecommendViewDao;
import com.iflytek.enity.Product;
import com.iflytek.enity.RecommendView;
import com.iflytek.service.RecomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomServiceImpl implements RecomService {
    @Autowired
    RecommendViewDao recommendViewDao;
    @Autowired
    ProductDao productDao;

    @Override
    public Result search(Integer state, String sort) {
        QueryWrapper<RecommendView> wrapper = new QueryWrapper<>();
        wrapper.eq("state", state);
        if (!"".equals(sort) && sort != null) {
            wrapper.eq("sort", sort);
        }
        List<RecommendView> list = recommendViewDao.selectList(wrapper);
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


