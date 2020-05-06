package com.iflytek.controller;

import com.iflytek.config.UploadUtils;
import com.iflytek.enity.*;
import com.iflytek.service.AdminService;
import com.iflytek.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @PostMapping("/login")
    public Result login(Admin admin){
        return adminService.login(admin);
    }


    @ResponseBody
    @PostMapping("/setPwd")
    public Result setPwd(Admin admin,String oldPwd){
        return adminService.setPwd(admin,oldPwd);
    }


    @ResponseBody
    @GetMapping("/userList")
    public Result getUserList(){
        return adminService.getUserList();
    }

    @ResponseBody
    @GetMapping("/userList/search")
    public Result getUserListBySearch(String username){
        return adminService.getUserListBySearch(username);
    }

    @ResponseBody
    @PostMapping("/user/add")
    public Result addUser(User u){
        return adminService.addUser(u);
    }


    @ResponseBody
    @PostMapping("/user/del")
    public Result delUser(User u){
        return adminService.delUser(u);
    }

    @GetMapping("/product/all")
    @ResponseBody
    public Result productAll(){
        return adminService.productAll();
    }

    @GetMapping("/product/search")
    @ResponseBody
    public Result productSearch(String keyword){
        return adminService.productSearch(keyword);
    }

    @PostMapping("/product/edit")
    @ResponseBody
    public Result productEdit(Product p){
        return adminService.productEdit(p);
    }

    @PostMapping("/product/add")
    @ResponseBody
    public Result productAdd(Product p){
        return adminService.productAdd(p);
    }

    @PostMapping("/product/del")
    @ResponseBody
    public Result productDel(Product p){
        return adminService.productDel(p);
    }


    @ResponseBody
    @GetMapping("/order/all")
    public Result getOrderList(){
        return adminService.getOrderList();
    }

    @ResponseBody
    @PostMapping("/order/edit")
    public Result orderEdit(Order o){
        return adminService.orderEdit(o);
    }

    @ResponseBody
    @GetMapping("/order/search")
    public Result orderSearch(String id,String address){
        return adminService.orderSearch(id,address);
    }

    @GetMapping("/info/all")
    @ResponseBody
    public Result infoAll(){
        return adminService.infoAll();
    }

    @GetMapping("/info/search")
    @ResponseBody
    public Result infoSearch(String keyword){
        return adminService.infoSearch(keyword);
    }

    @PostMapping("/info/edit")
    @ResponseBody
    public Result infoEdit(Information i){
        return adminService.infoEdit(i);
    }

    @PostMapping("/info/add")
    @ResponseBody
    public Result infoAdd(Information i){
        return adminService.infoAdd(i);
    }

    @PostMapping("/info/del")
    @ResponseBody
    public Result infoDel(Information i){
        return adminService.infoDel(i);
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,Long id)
    {
        Map<String,Object> map  = new HashMap<>();
        //String uploadDir = "B:/testpic/";
        File directory = new File("src/main/resources/static/res/static/img/");



        try {

            String  uploadDir= directory.getCanonicalPath();
            // 图片路径
            String imgUrl = null;
            //上传
            String filename = UploadUtils.upload(file, uploadDir, file.getOriginalFilename(),1);//上传文件
            if (filename != null) {
                imgUrl =  "/img/" + filename;
            }


          String pic=  "src/main/resources/static/res/static"+adminService.infoGetPicUrl(id);

            String n=UploadUtils.upload(file, pic, file.getOriginalFilename(),2);//删除原文件

            adminService.infoInterPic(id,imgUrl);//更新数据库

            map.put("code",200);
            map.put("msg","成功");
            map.put("data",imgUrl);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",500);
            map.put("msg","上传失败");
            map.put("data",null);
            return map;
        }


    }
    @GetMapping("/recom/all")
    @ResponseBody
    public Result recomAll(){
        return adminService.recomAll();
    }

    @PostMapping("/recom/edit")
    @ResponseBody
    public Result recomRdit(RecommendView r){
        return adminService.recomEdit(r);
    }

    @GetMapping("/recom/search")
    @ResponseBody
    public Result recomSearch(String keyword){
        return adminService.recomSearch(keyword);
    }

    @PostMapping("/recom/add")
    @ResponseBody
    public Result addRecom(Recommend r){
        return adminService.recomAdd(r);
    }
    @PostMapping("/recom/del")
    @ResponseBody
    public Result infoDel(Recommend r){
        return adminService.recomDel(r);
    }
}
