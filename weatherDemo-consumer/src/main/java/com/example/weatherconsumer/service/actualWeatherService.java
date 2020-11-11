package com.example.weatherconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

//name 为product项目中application.yml配置文件中的application.name;
//path 为product项目中application.yml配置文件中的context.path;
@FeignClient(name = "actualweather",path ="/actualweather" )
@Component
public interface actualWeatherService {
    @RequestMapping(value = "getActualWeather")
    String getActualWeather();
}