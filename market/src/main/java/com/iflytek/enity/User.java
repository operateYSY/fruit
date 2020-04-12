package com.iflytek.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;

@TableName(value = "sys_user")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String imgPic;

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
    private String address;
    private String telephone;



}
