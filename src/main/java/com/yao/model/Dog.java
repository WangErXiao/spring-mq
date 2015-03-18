package com.yao.model;

import java.io.Serializable;

/**
 * Created by root on 15-3-18.
 */
public class Dog implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
