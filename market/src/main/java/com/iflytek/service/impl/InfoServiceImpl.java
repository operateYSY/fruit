package com.iflytek.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iflytek.config.Result;
import com.iflytek.dao.InformationDao;
import com.iflytek.enity.Information;

import com.iflytek.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    InformationDao infoDao;

    @Override
    public Result list(int index,int num) {
        int num1 = (index-1)*num;
        List<Information>list= infoDao.getPageList( num1, num);
        return Result.build(200,"查询成功", list);
    }
    @Override
   public Result getAllSort() {

        List<String> list = infoDao.getAllSort();

        return Result.build(200, "查询成功", list);
    }

    @Override
  public  Result search(String sort,int index,int num){
        int num1 = (index-1)*num;
        List<Information> list;
        if(!"".equals(sort) && sort!=null){
            list = infoDao.getInformationListBySort(sort,num1,num);

        }else{
            list = infoDao.getPageList(num1,num);
        }
        return Result.build(200,"查询成功", list);
    }


}
