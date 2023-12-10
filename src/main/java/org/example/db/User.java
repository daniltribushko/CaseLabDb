package org.example.db;

public class User {
    private String sureName;
    private String name;
    private Integer age;
    private String city;
    private String country;
    private String subject;

    public User(String sureName, String name, Integer age, String city, String country, String subject) {
        this.sureName = sureName;
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
        this.subject = subject;
    }

    public User(){}

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
        return "User{" +
                "sureName='" + sureName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
