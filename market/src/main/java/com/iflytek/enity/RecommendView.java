package com.iflytek.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "view_recommend")
public class RecommendView extends Recommend{


   private String  name;
   private Double price;

    private   String sort;
    private   String pic;

 private String description;
}
