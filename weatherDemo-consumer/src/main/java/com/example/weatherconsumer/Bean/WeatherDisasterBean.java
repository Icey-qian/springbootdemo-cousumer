package com.example.weatherconsumer.Bean;

import com.alibaba.fastjson.annotation.JSONField;

public class WeatherDisasterBean {
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "pub_date")
    private String pub_date;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPub_date() {
        return pub_date;
    }
    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }
}
