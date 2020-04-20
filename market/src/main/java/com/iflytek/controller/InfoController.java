package com.iflytek.controller;

import com.iflytek.config.Result;
import com.iflytek.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    InfoService infoService;

    @GetMapping("/all")
    @ResponseBody
    public Result list(int index,int num){
        return infoService.list( index, num);
    }

    @GetMapping("/sort")
    @ResponseBody
    public Result getAllSort(){
        return infoService.getAllSort();
    }

    @GetMapping("/search")
    @ResponseBody
    public Result search(String sort,int index,int num){
        return infoService.search(sort,index,num);
    }
}
