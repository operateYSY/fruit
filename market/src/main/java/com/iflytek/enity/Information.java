package com.iflytek.enity;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value ="sys_information")
public class Information{
    @TableId(type = IdType.ID_WORKER)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    @TableField(fill = FieldFill.INSERT)
    private Date time;

    private String pic;
    private String text;
    @TableField(fill = FieldFill.INSERT)
    private String sort;
}