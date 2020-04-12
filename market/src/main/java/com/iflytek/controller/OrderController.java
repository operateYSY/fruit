package com.iflytek.controller;

import com.iflytek.enity.Order;
import com.iflytek.service.OrderService;
import com.iflytek.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @ResponseBody
    @PostMapping("/all")
    public Result getOrderList(Integer id){
        return orderService.getOrderList(id);
    }

    @ResponseBody
    @PostMapping("/add")
    public Result addOrder(Order order){
        return orderService.addOrder(order);
    }

}
