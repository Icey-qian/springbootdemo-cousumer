package com.example.weatherconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "weatherdisaster",path ="/weatherdisaster" )
@Component
public interface weatherDisasterService {
    @RequestMapping(value = "getWeatherDisaster")
    String getWeatherDisaster();
}
