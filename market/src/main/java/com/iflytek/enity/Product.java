package com.iflytek.enity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName(value = "sys_product")
public class Product {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Double price;

    @TableField(fill = FieldFill.INSERT)
    private String pic;
    private String description;
    private String sort;

    @TableField(fill = FieldFill.INSERT)
    private Integer state;

}
