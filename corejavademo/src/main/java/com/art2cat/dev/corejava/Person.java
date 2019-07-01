package com.art2cat.dev.corejava;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by Rorschach on 2017/3/30.
 */
public class Person implements Cloneable, Serializable {

    private String name;
    private int age;
    private int height;
    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    public Person(String name) {
        this.name = name;
    }


    @JsonCreator
    public Person(@JsonProperty("name") String name, @JsonProperty("age") int age,
            @JsonProperty("height") int height, @JsonProperty("gender") String gender,
            @JsonProperty("createTime") LocalDateTime createTime) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                height == person.height &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(createTime, person.createTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("height=" + height)
                .add("gender='" + gender + "'")
                .add("createTime='" + createTime.toString() + "'")
                .toString();
    }

    @Override
    public int hashCode() {
        return (7 * this.getAge() + 7 * this.getName().hashCode() + 11 * this.getHeight()) * 1024;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public void methodName(String name, int age, boolean off) {
        System.out.println("method 1");
    }

    public void methodName(int age, String name, boolean off) {
        System.out.println("method 2");
    }

    public void methodName(boolean off, String name, int age) {
        System.out.println("method 3");
    }

    public void methodName(boolean name, int age, boolean off) {
        System.out.println("method 4");
    }
}
