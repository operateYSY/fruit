package com.iflytek.enity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "view_recommend")
public class Recommend  {
   private   Integer id;
   private Long productId;
   private String  name;
   private Double price;
 private   String txt;
    private   String pic;
 private Integer state;
 private String description;
}
