package com.iflytek.service.impl;

import com.iflytek.dao.OrderDao;
import com.iflytek.dao.ProductDao;
import com.iflytek.dao.UserDao;

import com.iflytek.enity.Order;
import com.iflytek.enity.Orderv;
import com.iflytek.enity.Product;
import com.iflytek.enity.User;
import com.iflytek.service.OrderService;
import com.iflytek.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    UserDao userDao;

    @Override
    public Result getOrderList(Integer id) {
        List<Orderv> list =  orderDao.getOrderListByUserId(id);
       for(Orderv or:list){
           List<Product> prlist= productDao.getListById(or.getProductId());
           for(Product pr:prlist){
           or.setProductDescription(pr.getDescription());
           or.setProductName(pr.getName());
           or.setProductPic(pr.getPic());
           or.setProductSort(pr.getSort());
       }}

    return Result.build(200,"查询成功",list);
    }

    @Override
    public Result addOrder(Order order) {
        Product product = productDao.selectById(order.getProductId());
        order.setTotalPrice(product.getPrice() * order.getNum());
        User user = userDao.selectById(order.getUserId());
        order.setAddress(user.getAddress());
        int count = orderDao.insert(order);
        if(count > 0){
            return Result.build(200,"下单成功");
        }else{
            return Result.build(500,"下单失败");
        }
    }
}
