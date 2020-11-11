package com.example.weatherconsumer.Bean;

import com.alibaba.fastjson.annotation.JSONField;

public class WeatherPerFourBean {
    @JSONField(name = "time")
    private String time;

    @JSONField(name = "temperature")
    private String temperature;

    @JSONField(name = "code")
    private int code;

    @JSONField(name = "text")
    private String text;

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
