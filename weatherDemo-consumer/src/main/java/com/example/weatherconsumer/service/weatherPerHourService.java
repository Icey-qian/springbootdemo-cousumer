package com.example.weatherconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "weatherperhour",path ="/weatherperhour" )
@Component
public interface weatherPerHourService {
    @RequestMapping(value = "getWeatherPerHour")
    String getWeatherPerHour();
}
