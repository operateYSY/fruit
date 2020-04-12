package com.iflytek.service;


import com.iflytek.enity.Product;
import com.iflytek.utils.Result;

public interface ProductService {

    Result list();

    Result getOne(Product p);

    Result getAllSort();

    Result search(String keyword,String sort);

}
