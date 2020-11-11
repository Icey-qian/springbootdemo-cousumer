package com.example.weatherconsumer.controller;

import com.alibaba.fastjson.JSON;
import com.example.weatherconsumer.service.*;
import com.example.weatherconsumer.Bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class consumerController {
    @Autowired
    private actualWeatherService actualweatherservice;
    @Autowired
    private weatherPerHourService weatherPerHourService;
    @Autowired
    private weatherDisasterService weatherDisasterService;

    @RequestMapping(value = "getActualWeather")
    public String getActualWeather(Model model) {
        // 实时天气处理
        String actualResult = actualweatherservice.getActualWeather();
        String regEx0 = "now\":([\\s\\S]*),\"last_update\"";
        Pattern p=Pattern.compile(regEx0);
        Matcher m=p.matcher(actualResult);

        if (m.find()) {
            ActualWeatherBean vo = JSON.parseObject(m.group(1), ActualWeatherBean.class);
            model.addAttribute("text", vo.getText());
            model.addAttribute("temperature", vo.getTemperature()+"°C");
            // 天气图片文件路径
            String weatherPic="<img src=\"/consumer/images/weather/"+vo.getCode()+"@2x.png\">";
            model.addAttribute("html", weatherPic);
            model.addAttribute("feels_like",vo.getFeels_like());
            model.addAttribute("visibility",vo.getVisibility());
            model.addAttribute("wind_direction",vo.getWind_direction());
            model.addAttribute("wind_speed",vo.getWind_speed());
            model.addAttribute("clouds",vo.getClouds());
        }

        // 每4h显示
        String perHourResult = weatherPerHourService.getWeatherPerHour();
        String regEx1 = "\\{\"time\":(.*?)\\}";
        Pattern p1=Pattern.compile(regEx1);
        Matcher m1=p1.matcher(perHourResult);
        int num = 0;
        int now = 2;
        int flag = 0; // date change flag
        String time = "";
        while(m1.find()) {
            WeatherPerFourBean fb = JSON.parseObject(m1.group(0), WeatherPerFourBean.class);
            // time
            String regExp3 = "(?<=T).*(?=:00\\+)";
            Pattern p3=Pattern.compile(regExp3);
            Matcher m3=p3.matcher(fb.getTime());

            // NOW DATE
            String regExp2 = "(?<=-).*(?=T)";
            Pattern p2=Pattern.compile(regExp2);
            Matcher m2=p2.matcher(fb.getTime());

            if(m3.find()&&m2.find()){
                if(num == 0){
                    time = m2.group(0);
                    System.out.println(time);
                    model.addAttribute("time_1", "now");
                    model.addAttribute("temp_1", fb.getTemperature());
                    String textPic="<img src=\"/consumer/images/weather/"+fb.getCode()+"@1x.png\">";
                    model.addAttribute("text_1", textPic);
                }
                if((num + 1)%4 == 0 && num != 23){
                    if(!m2.group(0).equals(time)&&flag==0) {
                        model.addAttribute("time_" + now, m2.group(0));
                        flag = 1;
                    }
                    else{
                        model.addAttribute("time_" + now, m3.group(0));
                    }
                    model.addAttribute("temp_" + now, fb.getTemperature());
                    String textPic="<img src=\"/consumer/images/weather/"+fb.getCode()+"@1x.png\">";
                    model.addAttribute("text_"+now, textPic);
                    now++;
                }
                num++;
            }
        }
        return "actualWeather";
    }

    @RequestMapping(value = "getWeatherDetail")
    public String getWeatherDetail(Model model) {
        String actualResult = actualweatherservice.getActualWeather();
        String regEx0 = "now\":([\\s\\S]*),\"last_update\"";
        Pattern p=Pattern.compile(regEx0);
        Matcher m=p.matcher(actualResult);

        String disasterResult = weatherDisasterService.getWeatherDisaster();
        String regEx1 = "\"alarms\":\\[(.*?)\\}";
        Pattern p1=Pattern.compile(regEx1);
        Matcher m1=p1.matcher(disasterResult);

        if (m.find()) {
            ActualWeatherBean vo = JSON.parseObject(m.group(1), ActualWeatherBean.class);
            model.addAttribute("temperature", vo.getTemperature() + "°C");
            model.addAttribute("feels_like", vo.getFeels_like());
            model.addAttribute("visibility", vo.getVisibility());
            model.addAttribute("wind_direction", vo.getWind_direction());
            model.addAttribute("wind_speed", vo.getWind_speed());
            model.addAttribute("clouds", vo.getClouds());
            model.addAttribute("humidity", vo.getHumidity());
            model.addAttribute("wind_scale", vo.getWind_scale());
            model.addAttribute("wind_direction_degree", vo.getWind_direction_degree());
            model.addAttribute("pressure", vo.getPressure());
        }

        if(m1.find()) {
            String regEx2 = "(?<=\\[).*";
            Pattern p2 = Pattern.compile(regEx2);
            Matcher m2 = p2.matcher(m1.group(0));
            if(m2.find()&&!m2.group(0).equals("]}")) {
                WeatherDisasterBean wd = JSON.parseObject(m2.group(0), WeatherDisasterBean.class);
                model.addAttribute("description", "描述："+wd.getDescription());
                model.addAttribute("title", "标题："+wd.getTitle());
                model.addAttribute("pub_date", "发布时间："+wd.getPub_date());
            }
            else {
                model.addAttribute("description", "目前无灾害预警");
            }
        }

        return "weatherDetail";
    }

}