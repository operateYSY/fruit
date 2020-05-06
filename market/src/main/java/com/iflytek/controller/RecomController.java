package com.iflytek.controller;

import com.iflytek.config.Result;
import com.iflytek.service.RecomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recommend")
public class RecomController{
    @Autowired
    RecomService recomService;

    @ResponseBody
    @GetMapping("/search")
    public Result search(Integer state,String sort){
        return recomService.search(state,sort);
    }
    @ResponseBody
    @GetMapping("/all")
    public Result all(){
        return recomService.all();
    }
}
