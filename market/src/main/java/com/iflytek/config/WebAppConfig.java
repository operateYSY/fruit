package com.iflytek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**") // addPathPatterns("/**") 表示拦截所有的请求，
                .excludePathPatterns(
                        "/",
                        "/admin/**",
                        "/res/**",
                        "/header.html",
                        "/index.html",
                        "/login.html",
                        "/register.html",
                        "/information.html",
                        "/recommend.html",
                        "/product/all",
                        "/product/sort",
                        "/product/search",
                        "/user/login",
                        "/user/register",
                        "/info/all",
                        "/info/sort",
                        "/info/search",
                        "/img/**",
                        "/recommend/search",
                        "/recommend/all"
                );
            // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns(
                        "/admin/login.html",
                        "/admin/login",
                        "/img/**"
                );



    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:B:\\Gitmarket\\fruit\\market\\src\\main\\resources\\static\\res\\static\\img\\");

    }
}
//file:B:\\Gitmarket\\fruit\\market\\src\\main\\resources\\static\\res\\static\\img\\