package com.example.springbootdemocousumer.controller;

import com.example.springbootdemocousumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "getConsumer")
    public String getConsumer(){
        String str =  productService.getProduct();
        return str;
    }
}