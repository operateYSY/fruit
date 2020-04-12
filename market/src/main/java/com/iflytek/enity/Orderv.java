package com.iflytek.enity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.iflytek.enity.Order;
import lombok.Data;

@Data

public class Orderv extends Order {
    private String productName;
    private Double productPrice;
    private String productSort;
    private String productDescription;
    private String productPic;
}
