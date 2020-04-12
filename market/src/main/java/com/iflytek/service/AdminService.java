package com.iflytek.service;


import com.iflytek.enity.Admin;
import com.iflytek.enity.Order;
import com.iflytek.enity.Product;
import com.iflytek.enity.User;
import com.iflytek.utils.Result;

public interface AdminService {
    Result login(Admin admin);

    Result setPwd(Admin admin, String oldPwd);

    Result getUserList();

    Result getOrderList();

    Result delUser(User u);

    Result addUser(User u);

    Result getUserListBySearch(String username);

    Result productEdit(Product p);

    Result productAdd(Product p);

    Result productDel(Product p);

    Result productAll();

    Result productSearch(String keyword);

    Result orderEdit(Order o);

    Result orderSearch(String id,String address);
}
