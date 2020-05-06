package com.iflytek.service;


import com.iflytek.enity.*;
import com.iflytek.config.Result;

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

    Result infoAll();
    Result infoEdit(Information f);
    Result infoAdd(Information f);
    Result infoDel(Information i);
    Result infoSearch(String keyword);
    Result infoInterPic(Long id,String url);
    String infoGetPicUrl(Long id);

    Result recomAll();
    Result recomEdit(RecommendView r);
    Result recomSearch(String keyword);
    Result recomAdd(Recommend r);
    Result recomDel(Recommend r);
}
