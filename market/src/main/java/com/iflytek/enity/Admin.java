package com.iflytek.enity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_admin")
public class Admin {
    private Integer id;
    private String username;
    private String password;
}
