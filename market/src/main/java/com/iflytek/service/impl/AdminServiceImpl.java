package com.iflytek.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.iflytek.config.SafeUtils;
import com.iflytek.dao.*;
import com.iflytek.enity.*;
import com.iflytek.service.AdminService;
import com.iflytek.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;
    @Autowired
    InformationDao infoDao;
    @Autowired
    RecommendDao recommendDao;
    @Autowired
    RecommendViewDao recommendViewDao;

    @Override
    public Result login(Admin admin) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", admin.getUsername());
        wrapper.eq("password", admin.getPassword());
        Admin a = adminDao.selectOne(wrapper);
        if (a != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            request.getSession().setAttribute("adminId", a.getId());
            return Result.build(200,"登录成功",a);
        }
        return Result.build(500,"登录失败");
    }

    @Override
    public Result setPwd(Admin admin, String oldPwd) {
        UpdateWrapper<Admin> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", admin.getId());
        wrapper.eq("password", oldPwd);
        wrapper.set("password", admin.getPassword());
        adminDao.update(admin,wrapper);
        int count = adminDao.updateById(admin);
        if(count > 0){
            return Result.build(200,"修改成功");
        }
        return Result.build(500,"修改失败");
    }

    @Override
    public Result getUserList() {
        List<User> users = userDao.selectList(null);
        return Result.build(200,"查询成功",users);
    }

    @Override
    public Result getOrderList() {
        List<Orderv> list =  orderDao.getOrderList();
        for(Orderv or:list){
            List<Product> prlist= productDao.getListById(or.getProductId());
            for(Product pr:prlist){
                or.setProductDescription(pr.getDescription());
                or.setProductName(pr.getName());
                or.setProductPic(pr.getPic());
                or.setProductSort(pr.getSort());
                or.setProductPrice(pr.getPrice());
            }}
        return Result.build(200,"查询成功",list);
    }

    @Override
    public Result delUser(User u) {
        int count = userDao.deleteById(u.getId());
        if(count > 0){
            return Result.build(200,"删除成功");
        }
        return Result.build(500,"删除失败");
    }

    @Override
    public Result addUser(User u) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", u.getUsername());
        int exist = userDao.selectCount(wrapper);
        if(exist > 0){
            return Result.build(500,"用户名已存在~");
        }
        u.setPassword(SafeUtils.encode(u.getPassword()));
        int count = userDao.insert(u);
        if(count > 0){
            return Result.build(200,"注册成功");
        }
        return Result.build(500,"注册失败");
    }

    @Override
    public Result getUserListBySearch(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username", username);
        List<User> users = userDao.selectList(wrapper);
        return Result.build(200,"查询成功",users);
    }

    @Override
    public Result productEdit(Product p) {
        int count = productDao.updateById(p);
        if(count > 0){
            return Result.build(200,"更新成功");
        }
        return Result.build(500,"更新失败");
    }

    @Override
    public Result productAdd(Product p) {
        int count = productDao.insert(p);
        if(count > 0){
            return Result.build(200,"新增成功");
        }
        return Result.build(500,"新增失败");
    }

    @Override
    public Result productDel(Product p) {

        int count = productDao.deleteById(p.getId());
        if(count > 0){
            return Result.build(200,"删除成功");
        }
        return Result.build(500,"删除失败");
    }

    @Override
    public Result productAll() {
        List<Product> products = productDao.selectList(null);
        return Result.build(200,"查询成功", products);

    }

    @Override
    public Result productSearch(String keyword) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like("name", keyword);
        List<Product> products = productDao.selectList(wrapper);
        return Result.build(200,"查询成功", products);
    }

    @Override
    public Result orderEdit(Order o) {
        int count = orderDao.updateById(o);
        if(count > 0){
            return Result.build(200,"更新成功");
        }
        return Result.build(500,"更新失败");
    }

    @Override
    public Result orderSearch(String id,String address) {
        List<Orderv> list =  orderDao.getOrderListByKeywords("%"+id+"%","%"+address+"%");
        for(Orderv or:list){
            List<Product> prlist= productDao.getListById(or.getProductId());
            for(Product pr:prlist){
                or.setProductDescription(pr.getDescription());
                or.setProductName(pr.getName());
                or.setProductPic(pr.getPic());
                or.setProductSort(pr.getSort());
                or.setProductPrice(pr.getPrice());
            }}
        return Result.build(200,"查询成功",list);
    }
    @Override
    public Result infoAll(){
        List<Information> list=infoDao.selectList(null);
        return Result.build(200,"查询成功", list);
    }
    @Override
    public Result  infoEdit(Information f){
        int count = infoDao.updateById(f);
        if(count > 0){
            return Result.build(200,"更新成功");
        }
        return Result.build(500,"更新失败");
    }
    @Override
    public Result infoSearch(String keyword) {
        QueryWrapper<Information> wrapper = new QueryWrapper<>();
        wrapper.like("title", keyword);
        List<Information> products = infoDao.selectList(wrapper);
        return Result.build(200,"查询成功", products);
    }

    @Override
  public  Result infoAdd(Information f){

        int count = infoDao.insert(f);
        if(count > 0){
            return Result.build(200,"新增成功");
        }
        return Result.build(500,"新增失败");
    }
    @Override
   public  Result infoDel(Information i){

        int count = infoDao.deleteById(i.getId());
        if(count > 0){
            return Result.build(200,"删除成功");
        }
        return Result.build(500,"删除失败");
    }
    @Override
   public  Result infoInterPic(Long id,String url){
        Information info=new Information();
        info.setId(id);
        info.setPic(url);
       int count= infoDao.updateById(info);
        if(count > 0){
            return Result.build(200,"更新成功");
        }
        return Result.build(500,"更新失败");
    }


    @Override
    public  String infoGetPicUrl(Long id) {
   String url=infoDao.getPic(id);
   return url;
    }

    @Override
    public Result recomAll(){
        List<RecommendView> list=recommendViewDao.selectList(null);
        return Result.build(200,"查询成功", list);
    }
    @Override
    public Result  recomEdit(RecommendView r){
        int count = recommendViewDao.updateById(r);
        if(count > 0){
            return Result.build(200,"更新成功");
        }
        return Result.build(500,"更新失败");
    }
    @Override
    public Result recomSearch(String keyword) {
        QueryWrapper<RecommendView> wrapper = new QueryWrapper<>();
        wrapper.like("state", keyword);
        List<RecommendView> recommends = recommendViewDao.selectList(wrapper);
        return Result.build(200,"查询成功", recommends);
    }
    @Override
    public  Result recomAdd(Recommend r){


        int count = recommendDao.insert(r);
        if(count > 0){
            return Result.build(200,"新增成功");
        }
        return Result.build(500,"新增失败");
    }
    @Override
    public  Result recomDel(Recommend r){

        int count = recommendDao.deleteById(r.getId());
        if(count > 0){
            return Result.build(200,"删除成功");
        }
        return Result.build(500,"删除失败");
    }
}
