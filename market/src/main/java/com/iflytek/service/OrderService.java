package com.iflytek.service;

import com.iflytek.enity.Order;
import com.iflytek.utils.Result;

public interface OrderService {
    Result getOrderList(Integer id);

    Result addOrder(Order order);
}
