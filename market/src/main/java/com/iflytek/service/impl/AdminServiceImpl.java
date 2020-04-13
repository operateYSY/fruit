package com.iflytek.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.iflytek.dao.AdminDao;
import com.iflytek.dao.OrderDao;
import com.iflytek.dao.ProductDao;
import com.iflytek.dao.UserDao;
import com.iflytek.enity.Orderv;
import com.iflytek.enity.Admin;
import com.iflytek.enity.Order;
import com.iflytek.enity.Product;
import com.iflytek.enity.User;
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
            }}
        return Result.build(200,"查询成功",list);
    }
}
