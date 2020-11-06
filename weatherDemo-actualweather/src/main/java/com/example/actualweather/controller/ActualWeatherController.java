package com.example.actualweather.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActualWeatherController {
    @RequestMapping(value = "getActualWeather")
    public String getActualWeather() {
        String result = "";
        try {
            URL url = new URL("https://api.seniverse.com/v3/weather/now.json?key=SfoQkYWv4FyS_NzJ3&location=nanjing&language=zh-Hans&unit=c");//由网址创建URL对象
            InputStreamReader isReader = new InputStreamReader(url.openStream(), "UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;
            while ((str = br.readLine()) != null) {
                result += str;
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
        return result;
    }
}
