package com.iflytek.service;

import com.iflytek.config.Result;

import java.util.List;


public interface InfoService {

    Result list(int index,int num);

    Result getAllSort();

    Result search(String sort);
}
