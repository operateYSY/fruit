package com.iflytek.service;

import com.iflytek.config.Result;

public interface RecomService {
    Result search(int state,String sort);
    Result all();
}
