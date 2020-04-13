package com.iflytek.controller;

import com.iflytek.enity.Admin;
import com.iflytek.enity.Order;
import com.iflytek.enity.Product;
import com.iflytek.enity.User;
import com.iflytek.service.AdminService;
import com.iflytek.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @PostMapping("/login")
    public Result login(Admin admin){
        return adminService.login(admin);
    }


    @ResponseBody
    @PostMapping("/setPwd")
    public Result setPwd(Admin admin,String oldPwd){
        return adminService.setPwd(admin,oldPwd);
    }


    @ResponseBody
    @GetMapping("/userList")
    public Result getUserList(){
        return adminService.getUserList();
    }

    @ResponseBody
    @GetMapping("/userList/search")
    public Result getUserListBySearch(String username){
        return adminService.getUserListBySearch(username);
    }

    @ResponseBody
    @PostMapping("/user/add")
    public Result addUser(User u){
        return adminService.addUser(u);
    }


    @ResponseBody
    @PostMapping("/user/del")
    public Result delUser(User u){
        return adminService.delUser(u);
    }

    @GetMapping("/product/all")
    @ResponseBody
    public Result productAll(){
        return adminService.productAll();
    }

    @GetMapping("/product/search")
    @ResponseBody
    public Result productSearch(String keyword){
        return adminService.productSearch(keyword);
    }

    @PostMapping("/product/edit")
    @ResponseBody
    public Result productEdit(Product p){
        return adminService.productEdit(p);
    }

    @PostMapping("/product/add")
    @ResponseBody
    public Result productAdd(Product p){
        return adminService.productAdd(p);
    }

    @PostMapping("/product/del")
    @ResponseBody
    public Result productDel(Product p){
        return adminService.productDel(p);
    }


    @ResponseBody
    @GetMapping("/order/all")
    public Result getOrderList(){
        return adminService.getOrderList();
    }

    @ResponseBody
    @PostMapping("/order/edit")
    public Result orderEdit(Order o){
        return adminService.orderEdit(o);
    }

    @ResponseBody
    @GetMapping("/order/search")
    public Result orderSearch(String id,String address){
        return adminService.orderSearch(id,address);
    }

}
