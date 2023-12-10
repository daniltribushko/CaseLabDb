package org.example.db;

import lombok.*;


public class UserJdbc {
    private Integer id;
    private String sureName;
    private String name;
    private Integer age;
    private String city;
    private String country;
    private String subject;

    public UserJdbc(){}

    public UserJdbc(Integer id, String sureName, String name, Integer age, String city, String country, String subject) {
        this.id = id;
        this.sureName = sureName;
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "UserJdbc{" +
                "id=" + id +
                ", sureName='" + sureName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
