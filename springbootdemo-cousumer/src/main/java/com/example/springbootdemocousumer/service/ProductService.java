package com.example.springbootdemocousumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

//name 为product项目中application.yml配置文件中的application.name;
//path 为product项目中application.yml配置文件中的context.path;
@FeignClient(name = "product-server",path ="/product" )
//@Componet注解最好加上，不加idea会显示有错误，但是不影响系统运行；
@Component
public interface ProductService {
    @RequestMapping(value = "getProduct")
    String getProduct();
}