package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surename", nullable = false)
    private String sureName;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "subject", nullable = false)
    private String subject;

    public User(String sureName, String name, Integer age, String city, String country, String subject) {
        this.sureName = sureName;
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
        this.subject = subject;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getSureName() {
        return sureName;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "User{" +
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
