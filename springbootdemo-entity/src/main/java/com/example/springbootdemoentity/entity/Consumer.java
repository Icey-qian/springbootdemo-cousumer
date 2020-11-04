package com.example.springbootdemoentity.entity;

public class Consumer {

    private String name;
    private int age;
    private String add;
    private String email;

    public Consumer() {
        this.name = "name";
        this.age = 20;
        this.add = "上海市历史互通";
        this.email = "6666.qq.com";
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", add='" + add + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
