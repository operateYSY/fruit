package com.iflytek.enity;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_order")
public class Order{
    @TableId(type = IdType.ID_WORKER)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Integer userId;
    private Integer productId;
    private Double totalPrice;
    private Integer num;

    @TableField(fill = FieldFill.INSERT)
    private Date time;

    private String address;

    @TableField(fill = FieldFill.INSERT)
    private Integer state;
}
