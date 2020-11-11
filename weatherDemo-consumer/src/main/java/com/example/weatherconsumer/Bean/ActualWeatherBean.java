package com.example.weatherconsumer.Bean;

import com.alibaba.fastjson.annotation.JSONField;


public class ActualWeatherBean {
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "code")
    private int code;
    @JSONField(name = "temperature")
    private String temperature;
    @JSONField(name = "feels_like")
    private String feels_like;
    @JSONField(name = "visibility")
    private String visibility;
    @JSONField(name = "wind_direction")
    private String wind_direction;
    @JSONField(name = "wind_speed")
    private String wind_speed;
    @JSONField(name = "clouds")
    private String clouds;
    @JSONField(name = "wind_direction_degree")
    private String wind_direction_degree;
    @JSONField(name = "wind_scale")
    private String wind_scale;
    @JSONField(name = "humidity")
    private String humidity;
    @JSONField(name = "pressure")
    private String pressure;

    public String getWind_direction_degree() {
        return wind_direction_degree;
    }
    public void setWind_direction_degree(String wind_direction_degree) {
        this.wind_direction_degree = wind_direction_degree;
    }
    public String getWind_scale() {
        return wind_scale;
    }
    public void setWind_scale(String wind_scale) {
        this.wind_scale = wind_scale;
    }
    public String getHumidity() {
        return humidity;
    }
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getPressure() {
        return pressure;
    }
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getFeels_like() {
        return feels_like;
    }
    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getVisibility() {
        return visibility;
    }
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
    public String getWind_direction() {
        return wind_direction;
    }
    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }
    public String getWind_speed() {
        return wind_speed;
    }
    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }
    public String getClouds() {
        return clouds;
    }
    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

}
