package com.zhixing.staffid.entity;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "PERSON".
 */
@Entity
public class Person {

    @Id
    private Long id;

    @NotNull
    private String name;
    private String sex;
    private Integer age;

    @Generated
    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    @Generated
    public Person(Long id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}