package com.iflytek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{
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
                        "/product/all",
                        "/product/sort",
                        "/product/search",
                        "/user/login",
                        "/user/register",
                        "/info/all",
                        "/info/sort",
                        "/info/search"
                );
            // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns(
                        "/admin/login.html",
                        "/admin/login");


    }
}
