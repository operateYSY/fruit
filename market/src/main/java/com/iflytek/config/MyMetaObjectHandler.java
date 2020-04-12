package com.iflytek.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("time", new Date(), metaObject);
        setFieldValByName("state", 1, metaObject);
        setFieldValByName("pic", "/res/static/img/error.jpg", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
