package com.iflytek.controller;

import com.iflytek.enity.Product;
import com.iflytek.service.ProductService;
import com.iflytek.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping("/all")
    @ResponseBody
    public Result list(){
        return productService.list();
    }

    @GetMapping("/p")
    @ResponseBody
    public Result getOne(Product p){
        return productService.getOne(p);
    }

    @GetMapping("/sort")
    @ResponseBody
    public Result getAllSort(){
        return productService.getAllSort();
    }

    @GetMapping("/search")
    @ResponseBody
    public Result search(String keyword,String sort){
        return productService.search(keyword,sort);
    }

}
